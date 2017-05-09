import java.lang.*;
import java.util.Scanner;

class Main
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);	
		int N, k;
		int[] subMax = null;
		int[] superMax = null;
		int[] temp = null;
		N = sc.nextInt();
		k = sc.nextInt();
		subMax = new int[N];
		superMax = new int[N];
		for (int i = 0; i < subMax.length; i++)
		{
			subMax[i] = sc.nextInt();
		}
		for (int i = 0; i < subMax.length; i++)
                {
                        superMax[i] = sc.nextInt();
                }
		int skew = arrangeBookShelve(subMax, superMax, k);
		System.out.println(skew);
	}

	public static void buildMaxHeap(int[] A)
	{
		int heapSize = A.length - 1;
		for (int i = A.length/2 - 1; i >= 0; i--)
			maxHeapify(A, i, heapSize);
	}

	public static void maxHeapify(int[] A, int parent, int heapSize)
	{
		int l = leftChild(parent);
		int r = rightChild(parent);	
		int largest = parent;
		if (l <= heapSize && A[l] > A[largest])
		{
			largest = l;
		}
		if (r <= heapSize && A[r] > A[largest])
		{
			largest = r;
		}
		
		if (largest != parent)
		{
			swap(A, largest, parent);
			maxHeapify(A, largest, heapSize);
		}
	}

	public static int secondMax(int[] A)
	{
		return A[1] > A[2] ? 1 : 2;
	}
	
	public static int max(int[] A)
	{
		return 0;
	}
	
	public static int min(int[] A)
	{
		return (A.length + 2)/4;
	}
	
	public static int min(int[] A, int lessThan)
	{
		int to = A.length/2;
		int from = (A.length + 2)/4;
		for ( int i = to - 1; i >= from; i--)
		{
			int l = leftChild(i);
			int r = rightChild(i);
			if (l < A.length && A[l] <= lessThan)
				return l;
			else if (r < A.length && A[r] <= lessThan)
				return r;
		}
		return -1;
	}

	public static int leftChild(int parent)
	{
		return 2*parent + 1;
	}

	public static int rightChild(int parent)
	{
		return 2*parent + 2;
	}

	public static void displayArr(int[] arr)
        {
                for(Integer i : arr)
                {
                        System.out.print(i + " ");
                }
                System.out.println();
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
	
	public static int arrangeBookShelve(int[] subMax, int superMax[], int swipes)
	{
		buildMaxHeap(subMax);
		buildMaxHeap(superMax);	
		int[] temp = null;
		if (subMax[max(subMax)] > superMax[max(superMax)])
		{
			temp = subMax;
			subMax = superMax;
			superMax = temp;
		}
		int currentSkew = subMax[max(subMax)] + superMax[max(superMax)];
		int count = 0;
		int prevRoundSkew = currentSkew;

		while(swipes -- > 0)
		{
			int m = max(superMax);
			int sm = secondMax(superMax);
			int m_sub = max(subMax);
			int sm_sub = secondMax(subMax);
			
			if (superMax[m] + superMax[sm] < currentSkew)
			{
				int  min = min(subMax, superMax[sm]);
				if (min != -1)
				{
					currentSkew = superMax[m] + superMax[sm];	
				}
				else
				{
					min = min(subMax, subMax[m_sub]);
					if (min != -1)
					{
						currentSkew = superMax[m] + subMax[min];
						
					}
				}
				if (min != -1)
				{
					superMax[m] = superMax[m] ^ subMax[min];
        	                        subMax[min] = superMax[m] ^ subMax[min];
        	                        superMax[m] = superMax[m] ^ subMax[min];
	
                                	maxHeapify(superMax,0,superMax.length);
                                	buildMaxHeap(subMax);
                                	if (subMax[m_sub] > superMax[m])
                                	{
                                	       temp = subMax;
                                	       subMax = superMax;
                                	       superMax = temp;
                                	}
				}
			}
			else if (superMax[m] + subMax[sm_sub] < currentSkew)
			{
				int min = min(superMax, subMax[sm_sub]);
				if (min != -1)
				{
					currentSkew = superMax[m] + subMax[sm_sub];
				}
				else
				{
					min = min(superMax, subMax[m_sub]);
					if (min != -1)
					{
						currentSkew = superMax[m] + superMax[min];
					}
				}
				if (min != -1)
				{
					subMax[m_sub] = subMax[m_sub] ^ superMax[min];
                	                superMax[min] = subMax[m_sub] ^ superMax[min];
                	                subMax[m_sub] = subMax[m_sub] ^ superMax[min];
        	                        
	                                maxHeapify(subMax,0, subMax.length);
                                	buildMaxHeap(superMax);
                                	if (subMax[m_sub] > superMax[m])
                                	{
                                	      temp = subMax;
                                	      subMax = superMax;
                                	      superMax = temp;
                                	}
				}
			}
//			displayArr(subMax);
//			System.out.println();
//			displayArr(superMax);
//			System.out.println(currentSkew);
			if (prevRoundSkew == currentSkew)
			{
				count++;
			}
			else
			{
				prevRoundSkew = currentSkew;
			}
			if (count > 0)
			{
				return currentSkew;
			}
			
		}	
		return currentSkew;
	}
}
