public class Solution {
	public long reverse(long a) {
	    long num = 0;
	    StringBuffer bu = new StringBuffer();
	    for (long i = 0; i < 32; i++){
	        long b = (a & (1 << i)) >> i;
	        //System.out.print(b);
	        bu.append(b);
	        /*if (b == 1)
	            num += (b * (i<<(32 - i)));*/
	    }
	    return Long.parseLong(bu.toString(),2);
	}
}

