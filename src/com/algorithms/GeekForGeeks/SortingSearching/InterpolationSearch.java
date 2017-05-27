import java.util.*;
import java.lang.*;

public class InterpolationSearch{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int search = sc.nextInt();
		int low = 0, high = n - 1;

		while(arr[high] >= search && search > arr[low] ){
			double rise = high - low;
			double run = arr[high] - arr[low];
			double slope = rise / run;
			int index = (int) (slope * search) + low;
			if (arr[index] > search ){
				high = index - 1;
			} else if (arr[index] < search ) {
				low = index + 1;
			} else {
				low = index;
			}
		}
		if (arr[low] == search) {
			System.out.println("Found at index "+ low );
		} else {
			System.out.println("Not Found");
		}

	}

}
