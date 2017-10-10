import java.util.*;

class Main
{
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
			int n = sc.nextInt();
			int[] arr = new int[n];
			while(n > 0)
			{
				arr[arr.length - n--] = sc.nextInt();	
			}
			System.out.println(isRainbow(arr) ? "yes" : "no");
		}
	}


	public static boolean isRainbow(int[] arr)
	{
		/*boolean isIncreasing = true;
		int max = -1;
		int maxpos = -1;
		if (arr.length % 2 == 0)
			return false;

		for (int i = 0; i < arr.length; i++)
		{
			if (max < arr[i])
			{
				max = arr[i];
				isIncreasing = true;
				maxpos = i;
			}
			else if (max == arr[i])
			{
				isIncreasing = false;
			}
		}

		// if there were 2 max elements or if array length is not 
		// valid for a rainbow array it will fail
		if (!isIncreasing || arr.length != (2 * maxpos + 1))
			return false;

		int[] stack = new int[max+1];
		int prev = -1;

		try
		{
			// add stack while verifying increasing order
			for (int i = 0; i <= maxpos; i++)
			{
				if (prev == -1 || prev == arr[i] || (prev + 1) == arr[i])
					prev = arr[i];
				else
					return false;
				stack[arr[i]]++;
			}
		}
		catch(Exception e)
		{
			// if element more than max was accessed then fail
			return false;
		}

		prev = -1;
		try
		{
			// substract stack
			for (int i = maxpos; i < arr.length; i++)
			{
				if (prev == -1 || prev == arr[i] || (prev - 1) == arr[i])
					prev = arr[i];
				else
					return false;
				stack[arr[i]]--;
			}
		}
		catch (Exception e)
		{
			// if element more than max was raised then fail
			return false;
		}

		for (int i = 0; i < stack.length; i++)
		{
			if (stack[i] != 0)
				return false;
		}

		return true;
		*/
		if (arr[0] != arr[arr.length - 1])
			return false;

		int i = 1;
		int j = arr.length - 2;
		int prev = arr[0] - 1;
		
		while(i < j)
		{
			if (!(arr[i] == arr[i - 1] || arr[i] == arr[i - 1] + 1))
			{
				return false;	
			}

			if (arr[i] == arr[j])
			{
				i++;
				j--;
			}
			else
				return false;
		}

		return arr[i] != arr[i - 1] && arr[i]  == arr[i] + 1 ;
	}

}
