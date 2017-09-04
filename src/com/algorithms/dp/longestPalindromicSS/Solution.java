import java.util.*;
class Solution {

	int[][] mem;

	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		Solution s = new Solution();
		s.mem = new int[s1.length()][s1.length()];
		System.out.println(s.getLongestPalindromicSS(s1));
	}


	public String getLongestPalindromicSS(String s1){
		int l = getMaxLen(s1, 0, s1.length() - 1);	
		if (l <= 1) return ""; 
		return getSubStr(s1, 0, s1.length() - 1);
	}

	public String getSubStr(String s1, int l, int r){
		StringBuilder lS = new StringBuilder();
		Character ex = null;
		while(l <= r){
			if (l == r) {
				ex = s1.charAt(l);	
				l++;
			}
			if (((Character)s1.charAt(l)).equals(s1.charAt(r))){
				lS.append(s1.charAt(l));
				l++;r--;
			} else if (mem[l + 1][r] > mem[l][r - 1]){
				l = l + 1;
			} else{
				r = r - 1;
			}
		}
		StringBuilder rS = new StringBuilder(lS);
		return ex == null ? lS.append(rS.reverse()).toString() : lS.append(ex).append(rS.reverse()).toString();

	}

	public int getMaxLen(String s1, int l, int r){
		if (mem[l][r] > 0) return mem[l][r];

		if (l == r) return 1;
		else if (l > r) return 0;

		int val = 0;
		if (((Character)s1.charAt(l)).equals(s1.charAt(r))){
			val = 2 + getMaxLen(s1, l + 1, r - 1);
		} else {
			val = Math.max(getMaxLen(s1, l + 1, r), getMaxLen(s1, l, r - 1));
		}

		mem[l][r] = val;

		return mem[l][r];
	}

	

}
