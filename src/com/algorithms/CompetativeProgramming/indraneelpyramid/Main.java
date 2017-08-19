import java.util.*;
import java.io.*;

class Main{
	public static void main(String args[]) throws IOException{
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(
                              new InputStreamReader(System.in));
		int[] arr = new int[Integer.parseInt(br.readLine())];

		for (int i = 0; i < arr.length; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = Math.min(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(arr);
		int height = 0;
		for (int i = 0; i < arr.length; i++){
			if (height < arr[i]){
				height++;
			}
		}
		System.out.println(height);	
	}
}
