import java.util.*;

class Solution{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while(t-- > 0){
			int n = sc.nextInt();
			int[] arr = new int[n];
			while(n > 0){
				arr[arr.length - n--] = sc.nextInt();
			}
			long sum = 0;
			for (int i = 1; i < arr.length; i++){
				sum += Math.abs(Math.max(arr[i], arr[i-1]) - 1);
			}
			System.out.println(sum);
		}
	}

}
