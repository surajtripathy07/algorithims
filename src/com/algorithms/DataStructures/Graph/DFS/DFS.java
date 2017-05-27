import java.util.*;

public class DFS {
	public Object adj[];
	public int visited[];		
	
	public static void main(String[] args){
		DFS d = new DFS();
		Scanner sc = new Scanner(System.in);
		// will hold number of connected components in the graph
		int connectedComponents = 0;

		int nodes = sc.nextInt();
		int edges = sc.nextInt();
		// List of nodes
		d.adj = new Object[nodes];
		// boolean arr to denote if a node is visted (1). By default it is not visited (0)
		d.visited = new int[nodes];

		for (int i = 0; i < edges; i++){
			int n1 = sc.nextInt() - 1;
			int n2 = sc.nextInt() - 1;
			// Add adjecent nodes
			if (d.adj[n1] == null){
				d.adj[n1] = new ArrayList<Integer>();
			}
			((ArrayList<Integer>)d.adj[n1]).add(n2);
			
			// As its unidirectional Add link bothways
			if (d.adj[n2] == null){
                                d.adj[n2] = new ArrayList<Integer>();
                        }
                        ((ArrayList<Integer>)d.adj[n2]).add(n1);
		}

		for (int i = 0; i < d.adj.length; i++){
			if (d.visited[i] == 0){
				d.dfs(i);
				connectedComponents++;
			}
		}
		System.out.println("Connected Components :"+connectedComponents);
		
	}

	public void dfs(int j){
		visited[j] = 1;
		System.out.println("Processing "+j);
		for (int i = 0; i < ((ArrayList<Integer>) adj[j]).size(); i++){
			if (visited[((ArrayList<Integer>) adj[j]).get(i)] == 0){
				dfs(((ArrayList<Integer>) adj[j]).get(i));	
			}
		}	
	}

}
