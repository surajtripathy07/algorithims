import java.util.*;

public class Solution{
	public static Map<String, Long> mem = new HashMap<String, Long>();		
	public static long count;
	
	public static long permuteVal(int pos, long left, long[] arr){

		String key = pos+"-"+left;
		if (mem.containsKey(key)){
			//System.out.println("In");
			return mem.get(key);
		}
		if (left < 0) return 0;
		else if (left == 0){
			return 1;
		}
		long val = 0;
		for (int i = pos; i < arr.length; i++){
			//if (mem.containsKey(left - arr[i])){
			//	val += mem.get(left -arr[i]);
			//} else {
				val += permuteVal(i, left - arr[i], arr);
			//}
		}
		mem.put(key, val);
		return val;
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		long[] arr = new long[m];
		while(m > 0){
			arr[arr.length - m--] = sc.nextLong();
		}
		System.out.println(permuteVal(0, n, arr));	
	}

}
