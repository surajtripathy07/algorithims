import java.util.*;

class Square{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int[] x = new int[4];
		int[] y = new int[4];

		int inp = 4;
		while(inp > 0){
			x[4 - inp] = sc.nextInt();
			y[4 - inp--] = sc.nextInt();
		}

		int side = -1;
		int diagonal = -1;
		for (int i = 1; i < 4; i++){
			int d = distance(x[0], y[0], x[i], y[i]);
			//System.out.println("Distance sqare between "+x[0]+" "+ y[0]+" and "+ x[i]+" "+ y[i]+ " is "+d);
			if (side < 0){
				side = d;
				diagonal = d;
			} else {
				if (d > side){
					if (d > diagonal){
						diagonal = d;	
					} else {
						System.out.println("No");
						return;
					}
				} else {
					if (d < side && diagonal == side){
						side = d;
					} else if (d != side){
						System.out.println("No");
						return;
					}
				}
			}
		}
		if (diagonal == 2*side) System.out.println("Yes");
		else System.out.println("No");
		
	}

	public static int distance(int x1, int y1, int x2, int y2){
		return (int)(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1),2));
	}
}
