import java.lang.*;

public class Main
{
	public static Boolean isBoxPicked = false;
	public static Integer cranePosition = 0;
	public static Integer maxHeight = 0;
	public static Integer[] top = null;
	
	public static void moveLeft()
	{
		if (cranePosition > 0)
		{
			cranePosition--;
		}

	}
	
	public static void moveRight()
	{
		if (cranePosition < top.length-1)
		{
			cranePosition++;
		}	
	}
	
	public static void pickBox()
	{
		if (!isBoxPicked && top[cranePosition] > 0)
		{
			top[cranePosition]--;
			isBoxPicked = true;
		}	
	}
	
	public static void dropBox()
	{
		if (isBoxPicked && top[cranePosition] < maxHeight)
		{
			top[cranePosition]++;
			isBoxPicked = false;
		}	
	}

	public static void printBoxStates()
	{
		for(int i = 0; i < Main.top.length; i++)
		{
			System.out.print(top[i] + " ");
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		java.io.BufferedReader inputR = new java.io.BufferedReader
		(new java.io.InputStreamReader (System.in));
		String dimensions = inputR.readLine();
		String[] input = dimensions.split(" ");
		Main.maxHeight = Integer.parseInt(input[1]);
		Main.top = new Integer[Integer.parseInt(input[0])];
		
	 	String[] boxTop = ((String) inputR.readLine()).split(" ");

		for (int i = 0; i < top.length; i++)
		{
			top[i] = Integer.parseInt(boxTop[i]);
		}
		
		String[] choices = ((String) inputR.readLine()).split(" ");
		int choice;
		int i = 0;
		do 
		{
			choice = Integer.parseInt(choices[i++]);
			
			switch (choice)
			{
				case 1: Main.moveLeft(); break;
				case 2: Main.moveRight(); break;
				case 3: Main.pickBox(); break;
				case 4: Main.dropBox(); break;
			}
		}
		while(choice != 0);
		Main.printBoxStates();	
	}
} 
