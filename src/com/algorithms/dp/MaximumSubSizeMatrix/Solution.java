import java.util.*;

public class Solution{

	public static void main(String args[]){

		Solution s = new Solution();
	
		int[][] m ={{0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1}}; 
		System.out.println(s.getMax(m));	
			
	}

	public int getMax(int[][] m){
		int[][] arr = new int[m.length][m[0].length];

		for (int i = 0; i < m.length; i++){
			arr[i][0] = m[i][0];
		}

		for (int i = 1; i < m[0].length; i++){
			arr[0][i] = m[0][i];
		}
	
		int max = -1;

		for (int i = 1; i < m.length; i++){
			for (int j = 1; j < m[0].length; j++){
				if (m[i][j] == 0) continue;
				arr[i][j] = min(arr[i][j-1], arr[i-1][j-1], arr[i-1][j]) + 1; 
		
				if (arr[i][j] > max){
					max = arr[i][j];
				}
			}
		}	
	
		return max;
	
	}

	public int min(int a, int b, int c){
		return Math.min(a, Math.min(b, c));
	}

}
