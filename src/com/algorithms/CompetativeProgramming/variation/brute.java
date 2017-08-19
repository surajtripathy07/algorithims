class brute
{

	public static void main(String args[])
	{
		int count = 0;
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 10};
		for (int i = 0; i < arr.length - 1; i++)
		{
			for (int j = i+1; j < arr.length; j++)
			{
				if (Math.abs(arr[i] - arr[j]) >= 4)
				{
					System.out.println(arr[i] +" "+ arr[j]);
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
