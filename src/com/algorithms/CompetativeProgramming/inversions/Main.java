import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] arr;
		while(t-- > 0){
			int n = sc.nextInt();
			arr = new int[n];
			while(n > 0){
				arr[arr.length - n--] = sc.nextInt();
			}
			System.out.println(getcount(arr, 0, arr.length - 1));
/*			for (int i = 0; i <= arr.length - 1; i++){
                	        System.out.print(arr[i]+" ");
                	}
*/
		}

	}

	public static int getcount(int[] arr, int left, int right){
		if (left < right){
			int mid = left + (right - left)/2;
			int c = getcount(arr, left, mid);
			int d = getcount(arr, mid + 1, right);
			return merge(arr, left, right, mid) + c + d;
		}
		return 0;
	}

	public static int merge(int[] arr, int left, int right, int mid){
		int l = left;
		int le = mid;
		int rs = mid + 1;
		int[] temp = new int[right - left + 1];
		int p = 0;
		int count = 0;
		int smallShifted = 0;
		boolean isFirst = true;
		while(left <= le || rs <= right)
		{	
			if (left <= le && rs <= right && arr[left] > arr[rs] || left == le + 1){
				if (left != le + 1){
					smallShifted++;
				}
				temp[p] = arr[rs];

				if (left <= le && arr[left] != arr[rs]){
					count++;
				}
				//System.out.println("Adding "+arr[rs]+" from index-"+rs+" over "+arr[left]);	
				rs++;
			}else{

				if (rs == right + 1){
					if (arr[left] != arr[rs - 1]){
						if (!isFirst)
							count += smallShifted;
						else
							isFirst = false;
					}
				} else {
					smallShifted = 0;
				}
				temp[p] = arr[left];
                                //System.out.println("Adding "+arr[left]+" from index-"+left+" over "+arr[rs]);
				left++;
			}
			p++;
		}
		for (int i = l; i <= right; i++){
			arr[i] = temp[i - l];
		}
		return count;		
	}

}
