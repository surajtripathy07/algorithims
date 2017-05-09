import java.util.*;
import java.lang.*;
/* O(root(n))
*
	The time complexity of Jump Search is between Linear Search ( ( O(n) ) and Binary Search ( O (Log n) ).
*/
class JumpSearch{

	public static void main(String args[]){
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}
		
		int step = (int)Math.sqrt(n);
//		System.out.println("Step is "+step);
		int search = sc.nextInt();
		int i = 0;
		// Jump by "step" until we have val greater than search amount
		while(i < n && arr[i] <= search){
//			System.out.println("i is "+i+" a[i] is "+arr[i]);
			i += step;
		}	
		if (i > n){
			i = n;
		}

		for (int j = i - step; j < i; j++){
//			System.out.println("checking j= "+j+" and a[j]= "+arr[j]);
			if (arr[j] == search)	{
				System.out.println(j);
				return;
			}
		}
		System.out.println("-1");
	}	
}
