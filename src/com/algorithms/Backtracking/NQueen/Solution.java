import java.util.*;

class Solution{

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
			int c = 17;
			int hash = 7;
                        hash = 31 * hash + x + c;
			return 31 * hash + y + c; 
                }
        }
	
	public ArrayList<Pair> queenPos = new ArrayList<Pair>();

	public static void main(String args[]){
		Solution s = new Solution();
		Scanner sc = new Scanner(System.in);
		int bs = sc.nextInt();
		int[][] board = new int[bs][bs];
		boolean placeQ = s.placeQueen(0, 0, board);

		if (placeQ){
			s.showBoard(board);
		} else {
			System.out.println("Failed to place Queen");
		}
		
		
	}

	public void showBoard(int[][] board){
		for (int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public boolean placeQueen(int file, int col, int[][] board){
		
		if (file >= board.length || col >= board[0].length) return false;
		if (isSafe(file, col, board)){

			board[file][ col] = 1;
			queenPos.add(new Pair(file, col));
			if (file == board.length - 1 || placeQueen(file + 1, 0, board)){
				return true;
			}
			else{
				// back track
				board[file][col] = 0;
				queenPos.remove(queenPos.size() - 1);
			}
		}
		return placeQueen(file, col + 1, board);
	}

	public boolean isSafe(int file, int col, int[][] board){
		for (Pair p : queenPos){
			if (canAttack(p.x, p.y, file, col)){
				return false;
			}
		}
		return true;	
	}

	public boolean canAttack(int q1X, int q1Y, int q2X, int q2Y){
		// Rook attack
		if (q1X == q2X || q1Y == q2Y){
			return true;
		}

		// Bishops attack
		// (i+1, j+1), (i+1, j-1), (i-1, j+1), (i-1, j-1)
		if (Math.abs(q2Y-q1Y) == Math.abs(q2X-q1X)){
			return true;
		}
		return false;

	}

}
