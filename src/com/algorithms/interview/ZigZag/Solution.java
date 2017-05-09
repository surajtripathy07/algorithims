import java.util.*;
public class Solution {
	public String convert(String a, int b) {
		StringBuilder bl = new StringBuilder();
		int row = 0;
		while(row < b){
			int increment = 0;	
			if(row == 0 || row == b - 1){
				increment = (2*b - 2);
			} else {
				increment = (2*(b - row) - 2);
			}

			for (int i = row; i < a.length(); i+=increment){
				bl.append(a.charAt(i));
			}
			row++;
		}
		return bl.toString();
	}
	public static void main(String args[]){
		Solution s = new Solution();
		System.out.println(s.convert("SURAJHUAMADHAM", 5));
	}
}

