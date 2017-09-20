import java.util.*;

class Solution{


	public static void main(String args[]){
	
		Solution s = new Solution();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] rating = new int[n];

		while(n > 0){
			rating[rating.length - n--] = sc.nextInt();	
		}

		//System.out.println(s.minimumChoc(rating, 0, 0));
		int[] rev = new int[rating.length];
		boolean isInc = false;
		boolean isDec = false;
		int v = 0;
		for (int i = rating.length - 1; i > 0; i--){
			if ((isInc && rating[i - 1] < rating[i]) ||(isDec && rating[i - 1] > rating[i]) ){
				rev[i] = v;
				v = 0;	
			} else {
				rev[i] = v;
				while (i > 0 && rating[i - 1] == rating[i]){
					rev[i - 1] = rev[i]; i--;
				}

				if (isInc) v++;
				else if (isDec) v--;

				if (i == 1) break;
			}
			if (rating[i - 1] > rating[i]){
				isInc = true;
				isDec = false;
				if (i == rating.length - 1) v++;
			} else {
				isInc = false;
				isDec = true;
				if (i == rating.length - 1) v--;
			}
		}
		rev[0] = v;
		/*System.out.println();
		for (int i = 0; i < rating.length; i++){
			System.out.println(rev[i]);			
		}*/
		int o = Math.max(1, rev[0] + 1);
		for (int i = 1; i < rating.length; i++){
			System.out.print(o);

			if (rating[i - 1] < rating[i]){
				o++;
			} else  {
				
				
			}
		}
	
	}

}
