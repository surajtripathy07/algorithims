import java.util.*;

class LongSub{
	static int[][] memo;
	
	static String long_sub(String s1, String s2){
		if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) return null;

		subproblem(0, 0, s1, s2);
		return getSequence(0, 0, s1, s2, new StringBuilder());
	}
	// Bottom Up Approach
	static int subproblem(int i, int j, String s1, String s2){
		if (i == s1.length() || j == s2.length()) return 0;
		if (memo[i][j] < 0){
			if (s1.charAt(i) == s2.charAt(j)) memo[i][j] = 1 + subproblem(i + 1, j + 1, s1, s2);
			else memo[i][j] = Math.max(subproblem(i + 1, j, s1, s2), subproblem(i, j + 1, s1, s2));
		}
		return memo[i][j];
	}
	// Use memoized Result to get the Longest Sequence
	static String getSequence(int i, int j, String s1, String s2, StringBuilder b){
		while(i < s1.length() && j < s2.length()){
			if (s1.charAt(i) == s2.charAt(j)) {
				b.append(s1.charAt(i));
				i++;
				j++;
			} else if (i < s1.length()-1 && j < s2.length()-1){
				if (memo[i + 1][j] < memo[i][j + 1]) {
					j++;
				}else {
					i++;
				}
			}
		}
		return b.toString();
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		LongSub l = new LongSub();
		memo = new int[s1.length()][s2.length()];
		for (int i = 0; i < s1.length(); i++){
			for (int j = 0; j < s2.length(); j++){
				memo[i][j] = -1;
			}
		}
		System.out.println(long_sub(s1, s2));	
	}
}
