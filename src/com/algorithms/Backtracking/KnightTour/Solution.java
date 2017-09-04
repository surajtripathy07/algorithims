import java.util.*;

public class Solution{

	int[][] sol;
	int[] xMoves = {  2, 1, -1, -2, -2, -1,  1,  2 };
	int[] yMoves = {  1, 2,  2,  1, -1, -2, -2, -1 }; 
	int step = 0;

	public static void main(String args[]){
		Solution s = new Solution();

		int m = 8;
		int n = 8;
		s.sol = new int[m][n];
		s.knightTour();
	}

	public void knightTour(){
		boolean isTour = tour(0,0);
		if (isTour) displayTour();
		else System.out.println("Tour doesn't exist");
	}

	public void displayTour(){
		for (int i = 0; i < sol.length; i++){
			for (int j = 0; j < sol[0].length; j++){
				System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
	}

	public Boolean tour(int x, int y){

		if (x < 0 || x >= sol.length || y < 0 || y >= sol.length) return false;

		if (sol[x][y] > 0) return false;

		sol[x][y] = step + 1;
		if (isEnd(x, y, step)){
			return true;
		}
	
		for (int i = 0; i < xMoves.length; i++){
			++step;	
			Boolean val = tour(x + xMoves[i], y + yMoves[i]);
			if (val) return val;
			--step;
		}
		sol[x][y] = 0;
		return false;
	}

	public Boolean isEnd(int x, int y, int step){
		return (step == sol.length*sol[0].length - 1);
	}
	/*
	public int[][] heuristic(int x, int y){
		
		int[][] nxt = new int[8][3];
		int maxValid;
		int in = 0;
		for (int i = 0; i < xMoves.length; i++){
			int nxtX = x + xMoves[i];
			int nxtY = y + yMoves[i];
			if (nxtX < 0 || nxtX >= sol.length || nxtY < 0 || nxtY >= sol.length){
				continue;
			}
			int validMoves = 0;
			for (int j = 0; j < xMoves.length; j++){	
				int nxtX = x + xMoves[i];
	                        int nxtY = y + yMoves[i];
	                        if (nxtX < 0 || nxtX >= sol.length || nxtY < 0 || nxtY >= sol.length){
	                                continue;
	                        }
				validMoves++;
			}
			nxt[in][0] = nxtX;
			nxt[in][1] = nxtY;
			nxt[in][2] = validMoves;
			in++;
                }

		Arrays.sort(nxt, new Comparator(Integer[] a, Integer[] b){
			public int compare(Integer[] a, Integer[] b){
				if (a[0] == null) return -1;
				if (b[0] == null) return -1;
			}
		});

	}*/

}
