import java.lang.*;

class Main
{
	private static int count = 0;
	public static void main(String args[]) throws Exception
	{
		java.io.BufferedReader inputR = new java.io.BufferedReader
                (new java.io.InputStreamReader (System.in));
		String[] arrI = inputR.readLine().trim().split(" ");
		int[] arr = new int[arrI.length];
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = Integer.parseInt(arrI[i]);
		}
		quicksort(arr, 0, arr.length-1);
		displayArr(arr);
		System.out.println(count);
	}
	
	public static void displayArr(int[] arr)
	{
		for(Integer i : arr)
		{
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void quicksort(int[] arr, int p, int q)
	{
		if( p < q)
		{
			int m = randomPartition(arr, p,q);
			quicksort(arr, p, m - 1);
			count++;
			quicksort(arr, m + 1, q);
			count++;
		}
	}

	public static int randomPartition(int[] arr, int start, int end)
	{
		int pos = (start + end)/2;
		//int pos = end;
		/*while(pos > end ||  pos < start)
		{
			pos = (int)Math.random()*10;
		}*/
		arr = swap(arr, end, pos);
		return partition(arr, start, end);
	}

	public static int partition(int[] arr, int start, int end)
	{
		int i = start - 1;
		int j = start;
		
		int pivot = end;
		
		for ( ; j < end; j++)
		{
			if (arr[j] < arr[pivot])
			{
				swap(arr, ++i, j);
			}
		}
		swap(arr, ++i, pivot);
		return i;
	}


	public static int[] swap(int[] arr, int i, int j)
	{
		
		if (arr[i] != arr[j])
		{
			arr[i]=arr[i]^arr[j];
	        arr[j]=arr[i]^arr[j];
	        arr[i]=arr[i]^arr[j];
		}
		
		return arr;
	}

}
