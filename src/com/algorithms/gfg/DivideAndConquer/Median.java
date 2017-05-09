public class Median{

	public static void main(String args[]){
		System.out.println("Input n of arr, followed by n lines of data for array");
		int len = Util.nextInt();
		int arr[] = Util.read(new int[len], len);
		System.out.println("Input n of arr, followed by n lines of data for array");
		int len2 = Util.nextInt();
		int arr2[] = Util.read(new int[len2], len2);
		Median m = new Median();
		System.out.println(m.getMedian(m.merge(arr, arr2)));
	} 

	public float getMedian(int[] median){
		if (median.length % 2 == 0) {
			int mid = median.length/2 ;
			return ((float)median[mid - 1] + (float)median[mid])/2;
		} else {
			int mid = (median.length - 1)/2;
			return median[mid];
		}
	}
	
	public int[] merge(int[] arr1, int[] arr2){
		int i = 0, j = 0, nw = 0 ;
		int[] merge = new int[arr1.length+arr2.length];

		while(i < arr1.length && j < arr2.length){
			if (arr1[i] < arr2[j]){
				merge[nw++] = arr1[i++];
			} else {
				merge[nw++] = arr2[j++];
			}
		}

		while(i < arr1.length){
			merge[nw++] = arr1[i++];
		}
		while(j < arr2.length){
			merge[nw++] = arr2[j++];
		}

		return merge;
	}
}
