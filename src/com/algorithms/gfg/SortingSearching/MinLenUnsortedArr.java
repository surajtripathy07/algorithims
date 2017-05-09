import java.util.*;
import java.lang.*;


public class MinLenUnsortedArr{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++){
			arr[i] = sc.nextInt();
		}
		Integer start = null, end = arr.length - 1, min = null, max = null;

		for (int i = 1; i < arr.length; i++){
			if (start == null && arr[i] < arr[i - 1]){
				start = i - 1; 
				max = start;
				min = i;
			} else if (start != null) {
				// If end has not yet been modified
				if (end == arr.length - 1) {
					// If we have Value greater than Start
					if (arr[i] >= start){
						end = i;
					}
				} else {
					if (arr[i] <= start){
						end = arr.length - 1;
					}
				}
			}
			
			if (min != null && arr[i] < arr[min]){
				// set min
				min = i;
			}

			if (max != null){
				if (arr[i] > arr[max]){
					max = i;
				}else if (arr[i] < arr[max]){
					end = i;
				}
			}
		}

		if (arr[start] < arr[end] && end == arr.length - 1){
			end = end - 1;
		} 
		
		if (start != null){
			for (int i = 0; i < start; i++){
				if (arr[min] < arr[i]){
					start = i;
					break;
				}
			}
		}

		System.out.println("The unsorted arr has index "+start+" and "+end+".");	
	}
}
