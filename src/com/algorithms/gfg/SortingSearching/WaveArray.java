public class WaveArray{

	public static void main(String[] arg){
		int len = Util.nextInt();
		int[] arr = Util.read(new int[len], len);
		Util.display(arr);

		WaveArray w = new WaveArray();
		// minimal wave
		System.out.println("O(n) complexity wave");
		w.minimalWave(arr);
		Util.display(arr);
		System.out.println("O(nlg n complexity wave");
		w.sort(arr);
		arr = w.makeWave(arr);

		Util.display(arr);
	}
	
	public void minimalWave(int[] arr){
		for ( int i = 0; i < arr.length; i++){
			if (i % 2 == 0){
				if (i < arr.length - 1){
					if (arr[i] < arr[i + 1]) {
						int temp = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = temp;
					}
				}
				if (i > 0){
					if (arr[i] < arr[i - 1]){
						int temp = arr[i];
                                                arr[i] = arr[i - 1];
                                                arr[i - 1] = temp;
					}	
				}
			}
		}
		
	}	

	// O(nlogn)	
	public void sort(int[] arr){
		quicksort(arr, 0, arr.length - 1);		
	}

	public void quicksort(int[] arr, int start, int end){
		if (start < end){
			int part = randomPartition(arr, start, end);
			quicksort(arr, start, part - 1);
			quicksort(arr, part + 1, end);

		}
	}

	public int randomPartition(int[] arr, int start, int end){
		int mid = (start + end)/2;
		swap(arr, mid, end);
		
		return partition(arr, start, end);
	}

	public int partition(int[] arr, int start, int end){
		int i = start - 1;
		int pivot = end;
		for (int j = start; j < end; j++){
			// swap all values lower than pivot with i
			if (arr[j] < arr[pivot]){
				swap(arr, ++i, j);
			}	
		}
		// place pivot in its proper position
		swap(arr, ++i, pivot);
		return i;
	}

	public void swap(int[] arr, int i , int j){
		if (arr[i] != arr[j]){
			arr[i] = arr[i] ^ arr[j];
			arr[j] = arr[i] ^ arr[j];
			arr[i] = arr[i] ^ arr[j];
		}
	}
	
	public int[] makeWave(int[] arr){
		int mid = arr.length / 2;			
		int[] wave = new int[arr.length];
		int small = 0;
		for (int i = 0; i < arr.length; i++){
			if (i % 2 == 0){
				// all even positions are local maximas
				wave[i] = arr[mid++];
			} else {
				wave[i] = arr[small++];
			}
		}
		return wave;
	}
}
