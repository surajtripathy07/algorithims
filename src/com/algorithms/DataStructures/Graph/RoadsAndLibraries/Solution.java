import java.util.*;

public class Solution {
	public Object adj[];
	public int visited[];
	public long clib;
	public long croad;
	public long numberOfConnectedComp;
	
	public static void main(String[] args){
		Solution d = new Solution();
		Scanner sc = new Scanner(System.in);
		// will hold number of connected components in the graph
		int problems = sc.nextInt();
		while(problems-- > 0){
			d.processGraph(sc.nextInt(), sc.nextInt(), sc.nextLong(), sc.nextLong(), sc);	
		}

	}

	public void processGraph(int nodes, int edges, long costLib, long costRoad, Scanner sc){
		// will hold number of connected components in the graph
		try{
                clib = costLib;
		        croad = costRoad;

                // List of nodes
                adj = new Object[nodes];
                // boolean arr to denote if a node is visted (1). By default it is not visited (0)
                visited = new int[nodes];

                for (int i = 0; i < edges; i++){
                        int n1 = sc.nextInt() - 1;
                        int n2 = sc.nextInt() - 1;
                        // Add adjecent nodes
                        if (adj[n1] == null){
                                adj[n1] = new ArrayList<Integer>();
                        }
                        ((ArrayList<Integer>)adj[n1]).add(n2);
                        
                        // As its unidirectional Add link bothways
                        if (adj[n2] == null){
                                adj[n2] = new ArrayList<Integer>();
                        }
                        ((ArrayList<Integer>)adj[n2]).add(n1);
                }

                if (croad > clib){
                       System.out.println((long)nodes*(long)clib);
			         return;
                }
		       long cost = 0;
                for (int i = 0; i < adj.length; i++){
                        if (visited[i] == 0){
				            numberOfConnectedComp = 0;
                            dfs(i);
				            cost += ((long)croad * (numberOfConnectedComp - 1));
				            cost += clib;
                        }
                }
                System.out.println(cost);
		} catch(Exception e){
			throw e;
		}
	}

	public void dfs(int j){
		numberOfConnectedComp++;
		visited[j] = 1;
//		System.out.println("Processing "+j);
		if (adj[j] != null)
		for (int i = 0; i < ((ArrayList<Integer>) adj[j]).size(); i++){
			if (visited[((ArrayList<Integer>) adj[j]).get(i)] == 0){
				dfs(((ArrayList<Integer>) adj[j]).get(i));	
			}
		}	
	}

}
