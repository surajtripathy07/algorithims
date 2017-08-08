import java.util.*;

class Main
{
	public static void main(String args[])
	{
	 	Scanner sc = new Scanner(System.in);	
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] book1 = new int[N];
		int[] book2 = new int[N];
		for (int i = 0; i < N; i++)
		{
			book1[i] = sc.nextInt();
		//	System.out.print(book1[i] +" ");
		}
		//	System.out.println();
		for (int i = 0; i < N; i++)
                {
                        book2[i] = sc.nextInt();
		//	System.out.print(book2[i] +" ");
                }
		int m1 = getMax(book1);
		int m2 = getMax(book2);
		int skew = 0;
		//System.out.println(book1[m1] +" "+ book2[m2]);
		if (book1[m1] > book2[m2])
			skew = processSelves(book1, book2, m1, m2, getMin(book1), getMin(book2), K);
		else
			skew = processSelves(book2, book1, m2, m1, getMin(book2), getMin(book1), K);

		System.out.println(skew);
	}

	public static int processSelves(int[] book1, int[] book2, int p1, int p2, int s1, int s2, int k)
	{
		//System.out.println(book1[s1] +" "+ book2[p1]);
		if (book1[s1] < book2[p1] && k > 0)
		{
			int sp1 = getSecondMax(p1, book1);
			int sp2 = getSecondMax(p2, book2);
			//System.out.println(book1[sp1] +" "+ book2[sp2]);
			// if max of shelf 1 and 2nd Max of shelf 1 are the minimum	
			if (book1[p1] + book1[sp1] < book1[p1] + book2[sp2] && book1[p1] + book1[sp1] < book1[p1] + book2[p2])
			{
				int small = book2[s2];
				book2[s2] = book1[p1];
				book1[p1] = small;
				if (book1[p1] > book1[sp1])
					return processSelves(book2, book1, s2, p1, getMin(book2), getMin(book1), --k);
				else	
					return processSelves(book2, book1, s2, sp1, getMin(book2), getMin(book1), --k);				
			}
			else if (book1[p1] + book2[sp2] < book1[p1] + book2[p2])
			{
				int small = book1[s1];
				book1[s1] = book2[p2];
				book2[p2] = small;
				if (book2[p2] > book2[sp2])
					return processSelves(book1, book2, p1, p2, getMin(book1), getMin(book2), --k);
				else
					return processSelves(book1, book2, p1, sp2, getMin(book1), getMin(book2), --k);	
			}
		}
		return book1[p1] + book2[p2];
	}

	public static int getMin(int[] arr)
	{
		
		Integer min = -1;
		for (int i = 0 ; i < arr.length; i++)
		{
			if (min == -1 || arr[i] < arr[min])
			{
				min = i;
			}
		}
		return min;	
	}

	public static int getMax(int[] arr)
	{
		Integer max = -1;
                for (int i = 0 ; i < arr.length; i++)
                {
                        if (max == -1 || arr[i] > arr[max])
                        {
                                max = i;
                        }
                }
                return max;	
	}

	public static int getSecondMax(int pos, int[] arr)
	{
		Integer max = -1;
                for (int i = 0 ; i < arr.length; i++)
                {
			if (i == pos)
				continue;

                        if (max == -1 || arr[i] > arr[max])
                        {
                                max = i;
                        }
                }
                return max;	
	}
}
