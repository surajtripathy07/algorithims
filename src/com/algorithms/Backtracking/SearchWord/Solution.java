import java.util.*;
public class Solution{
	
	private static class Pair{
		public int x;
		public int y;

		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}

		public boolean equals(Pair p){
			return (p != null) && p.x == this.x && p.y == this.y;
		}

		public int hashCode(){
			return (31*this.x + this.y);
		}
	}	

	Set<Pair> visited;
	ArrayList<Pair> path = new ArrayList<Pair>();

	public static void main(String[] args){
		String[][] matrix = {{"t", "z", "x", "c", "d"}, {"a", "h", "n", "z", "x"}, {"h", "w", "o", "i", "o"}, {"o", "r", "n", "r", "n"}, {"a","b","r","i","n"}};
		String search = "hoaroz";
		Solution s = new Solution();		 
		s.visited = new HashSet<Pair>();
		s.displayPath(matrix, search);
	}

	public void displayPath(String[][] matrix, String toSearch){

		String firstChar = String.valueOf(toSearch.charAt(0));
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++){
				if (matrix[i][j].equals(firstChar)){
					boolean pathExists = findPath(i, j, toSearch, 1, matrix);
					if (pathExists){
						path.add(new Pair(i, j));
					}
				}
			}
		}

		if (path.isEmpty()) System.out.println("Path doesn't exist");
		else {
			for (int i = path.size() - 1; i >= 0; i--){
				Pair p = path.get(i);
				//System.out.print(matrix[p.x][p.y]);
				System.out.println("("+p.x+","+p.y+")"+" ");
			}

			System.out.println();
		}		
	}

	public boolean findPath(int i, int j, String search, int pos, String[][] matrix){
		if (pos >= search.length()){
			return true;
		}
		Pair[] moves = getListOfValidMoves(i, j);
		String nxtChar = String.valueOf(search.charAt(pos));

		for (Pair move: moves){
			if (move.x < 0 || move.x >= matrix.length || move.y < 0|| move.y >= matrix[0].length || visited.contains(move)){
				continue;
			}

			if (matrix[move.x][move.y].equals(nxtChar)){
				visited.add(move);
				boolean val = findPath(move.x, move.y, search, pos + 1, matrix);
				visited.remove(move);
				if (val){
					path.add(move);
					return val;
				}
			}
		}
		return false;		
	}

	public Pair[] getListOfValidMoves(int i , int j){
		return new Pair[] {new Pair(i + 1, j),new Pair(i - 1, j),new Pair(i, j + 1), new Pair(i , j - 1), new Pair(i+1, j+1), new Pair(i+1, j-1), new Pair(i-1, j+1), new Pair(i-1, j-1)};
	}

}
