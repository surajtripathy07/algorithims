import java.util.*;

class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[][] arr = new Integer[n][2];

		for (int i = 0; i < arr.length; i++){
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}

		Arrays.sort(arr, new Comparator<Integer[]>(){
			public int compare(Integer[] row1, Integer[] row2){
				int compX = Integer.compare(row1[0], row2[0]);
				int compY = Integer.compare(row1[1], row2[1]);
				if (compX == -1 || compY == -1){
					return -1;	
				} else if (compX == 0 && compY == 0) {
					return 0;
				} else {
					return 1;
				}
			}
		});
		int height = 0;
		for (int i = 0; i < arr.length; i++){
			System.out.println(arr[i][0]+" "+arr[i][1]);
			if (height < arr[i][0] && height < arr[i][1]){
				height++;
			}
		}
		System.out.println(height);	
	}
}
