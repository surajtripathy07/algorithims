import java.util.*;

class LongPal{
	static int[][] mem;
	static String getPal(String pal){
		// Get Max Length of Possible Palindrome and build mem table
		System.out.println("Max len of pal is "+subproblem(0, pal.length() - 1, pal));	
		// Parse mem table and build palindrome string
		return getPal(0, pal.length() - 1, pal);
	}

	static int subproblem(int i, int j, String pal){
		// As soon as i crosses j, we don't need to process
		if (i > j) return 0;
		// If subproblem has not been already evaluated, evaluate the subproblem
		if (mem[i][j] == 0){
			if (i == j) {
				// If i and j are overlapping, then we have reached the pivot of palindromic string
				mem[i][j] = 1;
			} else if (pal.charAt(i) == pal.charAt(j)){
				// if char at i and j are same then we can consider both to be a part of palindrom, so length increases by 2
				mem[i][j] = 2 + subproblem(i + 1, j - 1, pal);
			}else {
				// there are two ways to check for palindrome, increment i and keep j as is. Or decrement j and keep i as is.
				// Here, we do both and save the maximum of two as length
				mem[i][j] = Math.max(subproblem(i, j - 1, pal), subproblem(i + 1, j, pal));
			}
		}
		// return calculated or already existing value of pos i,j
		return mem[i][j];
	}	

	static String getPal(int i, int j, String pal){
		// to store characters to the left of pivot
		StringBuilder left = new StringBuilder();
		// to store characters at the right of pivot
		StringBuilder right = new StringBuilder();
		// untill i doesn't cross j continue
		while(i <= j){
			// if i and j over lap, add the pivot
			if (i == j) {
				left.append(pal.charAt(i));
				i++;
			} else if (pal.charAt(i) == pal.charAt(j)){
				left.append(pal.charAt(i));
				i = i + 1;
				right.append(pal.charAt(j));
				j = j - 1;
			}else { 
				// chose the longer palindromic path
				if (mem[i][j - 1] > mem[i + 1][j]){
					j = j - 1;
				} else {
					i = i + 1;
				}
			}
		}
		// here the buffer would hold something like this
		// left = nit
		// right = ni
		// so we reverse right to make the palindromic string as nitin
		left.append(right.reverse());
		return left.toString();
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);	
		String pal = sc.nextLine();
		mem = new int[pal.length()][pal.length()];

		System.out.println(getPal(pal));
	}

}
