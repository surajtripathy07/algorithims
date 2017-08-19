import java.util.*;
import java.io.*;

class Main
{

	public static void main(String args[]) throws Exception
	{
/*
		int[] t = {2, 4, 6, 8, 10};
                System.out.println(getLastSmaller(t, 300));
		System.out.println(getLastSmaller(t, 0));
                System.out.println(getLastSmaller(t, 7));
		System.out.println(getFirstLarger(t, 300));
                System.out.println(getFirstLarger(t, 0));
                System.out.println(getFirstLarger(t, 7));
		int[] t2 = {1, 3, 5, 7};
		System.out.println(getLastSmaller(t2, 300));
                System.out.println(getLastSmaller(t2, 0));
                System.out.println(getLastSmaller(t2, 6));
                System.out.println(getFirstLarger(t2, 300));
                System.out.println(getFirstLarger(t2, 0));
                System.out.println(getFirstLarger(t2, 6));	
*/	
/*		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(b.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		Integer[][] contest = new Integer[n][2];
		int[] wormholeV = new int[x];
		int[] wormholew = new int[y];
		for (int i = 0; i < n; i++)
                {
			String[] splt = b.readLine().split("\\s");
			contest[i][0] = Integer.parseInt(splt[0].trim());
			contest[i][1] = Integer.parseInt(splt[1].trim());
		}
	
		String[] V = b.readLine().split("\\s");
		for (int i = 0; i < x; i++)
		{
			wormholeV[i] = Integer.parseInt(V[i].trim());
		}
		String[] W = b.readLine().split("\\s");
		for (int i = 0; i < y; i++)
		{
			wormholew[i] = Integer.parseInt(W[i].trim());
		}
*/
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
                int x = sc.nextInt();
                int y = sc.nextInt();

		Integer[][] contest = new Integer[n][2];
                int[] wormholeV = new int[x];
                int[] wormholew = new int[y];
                for (int i = 0; i < n; i++)
                {
			contest[i][0] = sc.nextInt();
			contest[i][1] = sc.nextInt();
		}		

		for (int i = 0; i < x; i++)
                {
                        wormholeV[i] = sc.nextInt();
                }

                for (int i = 0; i < y; i++)
                {
                        wormholew[i] = sc.nextInt();
                }

		Arrays.sort(contest, new Comparator<Integer[]>(){
			public int compare(Integer[] a, Integer[] b)
			{
				return Integer.compare(a[0], b[0]);
			}
		});

		Arrays.sort(wormholeV);
		Arrays.sort(wormholew);
		
		int min = -1;
		for (int i = 0; i < contest.length; i++)
		{
			int left = getLastSmaller(wormholeV, contest[i][0]);
			int right = getFirstLarger(wormholew, contest[i][1]);
			if (left == -1 || right == -1)
				continue;

			int m = wormholew[right] - wormholeV[left] + 1;
			if (min == -1 || m < min)
			{
				min = m;
			}
		}

		System.out.print(min);
	}

	public static int getPos(int[]x, int element, int start, int end)
	{
		int mid = -1;
		while(start <= end)
		{
			mid = start + (end - start)/2;
			if (x[mid] == element)
				return mid;
			
			if (element > x[mid])
				start = mid + 1;
			else
				end = mid - 1;
		}
		return mid;
	}

	public static int getLastSmaller(int[]x, int element)
	{
		int m = getPos(x, element, 0, x.length - 1);
		if (m < 0)
			return m;

		if (x[m] == element)
			return m;

		return element < x[m] ? m - 1 : m;
	}

	public static int getFirstLarger(int[]x, int element)
	{
		int m = getPos(x, element, 0, x.length - 1);
		if (m < 0)
                        return 0;
		if (x[m] < element && m == x.length - 1)
			return -1;
		if (x[m] == element)
                        return m;

                return x[m] < element ? m + 1 : m;
	}

}
