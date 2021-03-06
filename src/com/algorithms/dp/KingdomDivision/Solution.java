import java.util.*;


class Solution {

	ArrayList<ArrayList<Integer>> graph;
	int[] parent;
	int[] visited;	
	int mod = 1000000007;
	long[][][] memo;

	public void dfs(int p){
		visited[p] = 1;
		ArrayList<Integer> children = graph.get(p);
		for (Integer child : children){
			if (visited[child] != 1){
				parent[child] = p;
				dfs(child);
			}
		}
	}
	
	public boolean isLeaf(int n){
		ArrayList<Integer> children = graph.get(n);
		for (Integer child: children){
			if (parent[child] == n){
				return false;
			}
		}
		return true;
	}

	public long partitionKingdom(int root, boolean colour, int score){	
		int clr = colour ? 1 : 0;
		if (memo[root][clr][score - 1] != 0){
			if (memo[root][clr][score - 1] == -1) return 0;
			else return memo[root][clr][score - 1];
		}
		if (isLeaf(root)){
			if (score == 1){
				memo[root][clr][score - 1] = -1;
				return 0;
			}
			if (score == 2){
				memo[root][clr][score - 1] = 1;
				return 1;
			}
		}

		ArrayList<Integer> children = graph.get(root);
		long ans = 1;
		long invalid = 1;
		for (Integer child : children){
			if (child != parent[root]){
				long numOfOppColor = partitionKingdom(child, !colour, 1);
				long numOfSameColor = partitionKingdom(child, colour, 2);
				invalid = (invalid * numOfOppColor) % mod;
				ans = (ans * (numOfOppColor + numOfSameColor)) % mod;
			}
		}

		if (score == 1){
			ans = (ans - invalid + mod) % mod;
		}
		memo[root][clr][score - 1] = (ans == 0) ? -1 : ans;
		return ans;	
	}

	public static void main(String[] args){
		Solution s = new Solution();
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		s.graph = new ArrayList<ArrayList<Integer>>(n + 1);
		s.memo = new long[n + 1][2][2];
		s.parent = new int[n + 1];
		s.visited = new int[n + 1];
		for (int i = 0; i <= n; i++){
			s.graph.add(new ArrayList<Integer>());
		}

		while(n-- > 1){
			int u = sc.nextInt();
			ArrayList<Integer> adj = s.graph.get(u);
			int v = sc.nextInt();
			adj.add(v);

			ArrayList<Integer> opAdj = s.graph.get(v);
			opAdj.add(u);
		}
		s.dfs(1);

		long ans = (s.partitionKingdom(1, true, 1) * 2) % s.mod;
		System.out.println(ans);
	}

}
