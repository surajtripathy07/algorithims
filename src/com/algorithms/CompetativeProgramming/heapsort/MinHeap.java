import java.lang.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		java.io.BufferedReader ir = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		String[] input = ir.readLine().split(" ");
		int[] arr = new int[input.length];
		for(int i = 0; i < input.length; i++)
		{
			arr[i] = Integer.parseInt(input[i]);
		}
		//buildMaxHeap(arr);
		heapsort(arr);
		displayArr(arr);
	}

        public static void displayArr(int[] arr)
        {
                for(Integer i : arr)
                {
                        System.out.print(i + " ");
                }
                System.out.println();
        }

	public static void printHeap(int[] arr)
	{
	}

	public static void heapsort(int[] A)
	{
		buildMinHeap(A);
		int heapSize = A.length - 1;
		for( int i = heapSize; i >= 0; i--)
		{
			System.out.println(extractMin(A, heapSize));
			heapSize--;
		}
	}


	public static void buildMinHeap(int[] A)
	{
		for (int i = A.length/2 - 1; i >= 0; i--)
		{
			minheapify(A, i, A.length); 
		}
	}	
	
	public static int extractMin(int[] A, int heapSize)
	{
		int min = A[0];
		swap(A, 0, heapSize);
		minheapify(A, 0, heapSize);
		return min;
	}

	
	public static void minheapify(int[] A, int parent, int len)
	{
		if (parent < A.length/2)
		{
			int leftChild = 2*parent + 1;
			int rightChild = 2*parent + 2;
			if ((leftChild < len) && A[parent] > A[leftChild])
			{
				swap(A, parent, leftChild);
				minheapify(A, leftChild, len);
			}
			if (rightChild < len && A[parent] > A[rightChild])
			{
				swap(A, parent, rightChild);
				minheapify(A, rightChild, len);
			}
		}
	}
	
	public static int parent(int i)
	{
		return i/2;
	}

	public static void swap(int[] A, int to, int from)
	{
		if (A[to] != A[from])
		{
			A[to] = A[to] ^ A[from];
			A[from] = A[to] ^ A[from];
			A[to] = A[to] ^ A[from];
		}
	}
}
