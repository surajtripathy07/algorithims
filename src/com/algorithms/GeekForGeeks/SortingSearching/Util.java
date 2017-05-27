import java.util.Scanner;

public class Util{
	static Scanner sc = new Scanner(System.in);
	
	public static Scanner getScanner(){
		return sc;
	}	

	public static int[] read(int[] arr, int len){
		while(len > 0){
			arr[arr.length - len--] = sc.nextInt();
		}
		return arr;
	}

	public static int nextInt(){
		return sc.nextInt();
	}

	public static String nextLine(){
		return sc.nextLine();
	}

	public static String next(){
		return sc.next();
	}

	public static void display(int[] arr){
                for(Integer i : arr){
                        System.out.print(i + " ");
                }
                System.out.println();
        }

}
