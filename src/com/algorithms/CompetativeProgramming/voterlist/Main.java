import java.lang.*;
import java.util.*;

class Main
{
 	public static void main (String[] args) throws java.lang.Exception
        {
                java.io.BufferedReader inputR = new java.io.BufferedReader
                (new java.io.InputStreamReader (System.in));
                String dimensions = inputR.readLine();
		String[] len = dimensions.split(" ");
		int[] N1 = new int[Integer.parseInt(len[0])];
		int[] N2 = new int[Integer.parseInt(len[1])];
		int[] N3 = new int[Integer.parseInt(len[2])];
		
		int totalLen = N1.length + N2.length + N3.length ;		

		for ( int i = 0; i < totalLen; i++)
		{
			if ( i < N1.length )
			{
				N1[i] = Integer.parseInt(inputR.readLine());
			}
			else if ( i < N1.length + N2.length)
			{
				N2[i - N1.length] = Integer.parseInt(inputR.readLine());
			}
			else
			{
				N3[i - N1.length - N2.length] = Integer.parseInt(inputR.readLine());
			}
		}

		//displayArr(N1);
		//displayArr(N2);
		//displayArr(N3);
		ArrayList<Integer> voterList = createVoterList(merge(N3,merge(N1,N2)));
		System.out.println(voterList.size());
		displayList(voterList);
		

	}

	public static int[] merge(int[] arr1, int[] arr2)
	{
		int i=0,j=0,k=0;
		int[] newarr = new int[arr1.length + arr2.length];
		while ( i < arr1.length && j < arr2.length)
		{
			if(arr1[i] < arr2[j])
			{
				newarr[k++] = arr1[i++];
			}
			else
			{
				newarr[k++] = arr2[j++];
			}
		}
		
		while (i < arr1.length)
			newarr[k++] = arr1[i++];

		while (j < arr2.length)
			newarr[k++] = arr2[j++];

		return newarr;
	}

	public static void displayArr(int[] disp)
	{
		for ( int i = 0; i < disp.length; i++)
		{
			System.out.println(disp[i]);
		}
	}
	
	public static void displayList(ArrayList<Integer> disp)
	{
		for(Integer i : disp)
			System.out.println(i);
	}

	public static ArrayList<Integer> createVoterList(int[] list)
	{
		ArrayList<Integer> finalList = new ArrayList<Integer> ();
		Integer prevIns = -1;
		for( int i = 1; i < list.length; i++)
		{
			if (list[i-1] == list[i] && list[i] != prevIns)
			{
				finalList.add(list[i]);		
				prevIns = list[i];
			}
		}
		return finalList;
		
	}
}

