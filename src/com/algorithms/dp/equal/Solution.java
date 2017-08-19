import java.util.*;

class Solution{

	public static int func(int[] arr, int m){
		int sum = 0;
		for (int i = 0; i < arr.length; i++){
			// Calculate delta of each ith value with minimum
			int delta = arr[i] - m;
			// Number of times we can remove 5 to make it reach min(m)
			sum += (delta / 5);
			// Number of times we can remove 2 (from the residue after removing 5) to make it reach min(m)
			sum += (delta % 5) / 2;
			// Number of 1's required to be removed after 5, 2
			sum += delta % 5 % 2;
		}
		return sum;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
			int n = sc.nextInt();
			int[] arr = new int[n];
			int m = 1 << 28;
			int i = 0;
			while(n > 0){
				arr[arr.length - n] = sc.nextInt();
				if (arr[arr.length - n] < m){
					m = arr[arr.length - n];
				}
				--n;
			}

			// https://stackoverflow.com/questions/37797031/unable-to-understand-algorithm
			System.out.println(Math.min(Math.min(func(arr, m), func(arr, m - 1)), func(arr, m-2)));
		}	
	}

}
