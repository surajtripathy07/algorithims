import java.util.*;

class Solution{


	public int mergeSort(int[] arr){
		return mergeSort(arr, new int[arr.length], 0, arr.length - 1);
	}

	public int mergeSort(int[] arr, int[] temp, int left, int right){
		int inversion = 0;
		if (left < right){
			int mid = left + (right - left)/2;	
			inversion = mergeSort(arr, temp, left, mid);
			inversion += mergeSort(arr, temp, mid + 1, right);

			inversion += merge(arr, temp, left, right, mid + 1);
		}	
		return inversion;
	}

	public int merge(int[] arr, int[] temp, int left, int right, int mid){
		int i, j, k;
		i = left;
		j = mid;
		k = left;
		int inversions = 0;
		while ( i <= mid - 1 && j <= right){
			if (arr[i] <= arr[j]){
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				inversions += (mid - i);
			}
		}

		while (i <= mid - 1){
			temp[k++] = arr[i++];
		}

		while(j <= right){
			temp[k++] = arr[j++];
		}

		for (i = left; i <= right; i++){
			arr[i] = temp[i];
		}
		return inversions;
	}

	public static void main(String args[]){
		Solution s = new Solution();
		int arr[] = new int[]{1, 20, 6, 4, 5};
		System.out.println(s.mergeSort(arr));
		
	}

}
