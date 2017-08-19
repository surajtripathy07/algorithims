import java.util.*;
class Main
{

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
		{
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
/*		for (int i = 0;  i < n; i++)
                {
                        System.out.print(i+"-"+arr[i]+" ");
                }
*/
		int count = 0;
		for (int i = 0; i < arr.length; i++)
		{
			int pos = find(arr[i] + k, arr, 0, arr.length - 1);
			if (pos == -1)
				continue;
			else
			{
				count += (arr.length - pos);
				//System.out.println(arr[pos]);
			}
		}
		System.out.println(count);

	}

	public static int find(int element, int[] arr, int left, int right)
	{
		int mid = -1;
		while (left <= right)
		{
			mid = left + (right - left)/2;
			if (element < arr[mid])
				right = mid - 1;	
			else if (element > arr[mid])
				left = mid + 1;
			else {
				 // handle duplicates
            			while(mid > 0 && arr[mid-1] == arr[mid]) 
				{
                			--mid;
            			}
		            break;
			}
		}
		
		return element <= arr[mid] ? mid : mid + 1;
	}

}
