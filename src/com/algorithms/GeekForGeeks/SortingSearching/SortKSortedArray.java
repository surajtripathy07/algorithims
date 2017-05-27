import java.util.Scanner;

public class SortKSortedArray{
	public static void main(String args[]){
		SortKSortedArray s = new SortKSortedArray();
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();

		int[] arr = new int[len];

		while(len > 0){
			arr[arr.length - len--] = sc.nextInt();
		}
		s.displayArray(arr);
		s.insertionSort(arr);
		s.displayArray(arr);
	}

	
	// Heap approach provides faster bounds O(nlog(k))
	public void buildMinHeap(int[] A, int heapSize){
		for (int i = heapSize/2; i > -1; i--){
			minHeapify(A, i, heapSize);
		}
	}

	

	public void minHeapify(int[] A, int i, int heapSize){
		int lC = leftChild(i, heapSize);	
		int rC = rightChild(i, heapSize);
		int parent = i;
		
		if (lC != -1 && A[parent] > A[lC]){
			parent = lC;
		}

		if (rC != -1 && A[parent] > A[rC]){
			parent = rC;
		}

		if (parent != i){
			int temp = A[parent];
			A[parent] = A[i];
			A[i] = temp;
			
			minHeapify(A, parent, heapSize);
		}
	}

	public int leftChild(int i, int heapSize){
		
		int lC = 2 * i + 1;
		if (lC >= heapSize){
			return -1;
		} else {
			return lC;
		}
	}

        public int rightChild(int i, int heapSize){

                int rC = 2 * i + 2;
                if (rC >= heapSize){
                        return -1;
                } else {
                        return rC;
                }
        }
//	O(nk). For small k it is almost linear.
	public void insertionSort(int[] arr){
		int move = 0;
		int count = 0;
		for (int i = 1; i < arr.length; i++){
			if (arr[i] < arr[i - 1]){
				int j = i - 1;
				move = arr[j+1];
				while(j > 0 && move < arr[j]){
					arr[j + 1] = arr[j];
					j--;
					count++;
				}
				// place move to i
				arr[j + 1] = move;
			}
			count++;
		}
		System.out.println("Number of Steps:"+count);
	}
	
	
	public static void displayArray(int[] arr){
		for(Integer i : arr){
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
