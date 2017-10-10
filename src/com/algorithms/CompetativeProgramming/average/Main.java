import java.util.*;

class Main{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		while(n > 0){
			a[a.length - n] = sc.nextInt();
		}
		Arrays.sort(a);

		int ct = 0;
		for (int i = 0; i < a.length; i++){
			int left = i - 1; int right = i + 1;
			int sm = 2 * a[i];
			if ((i > 0 && a[i] == a[i-1]) || (i < a.length - 1 && a[i] == a[i + 1])){
				                                ct++;
			} else {
				while (left > -1 && right < a.length){
					int lr = a[left] + a[right];
					if (lr > sm){
						left--;
					} else if (lr < sm) {
						right++;
					} else {
						ct++;
						break;
					}
				}
			}
		}

		System.out.println(ct);
		System.exit(0);
	}


}
