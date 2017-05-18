public class Solution {
	public int Mod(int a, int b, int c) {
	    boolean isneg = false;
	    if (a < 0){
	        isneg = true;
	    }
	    if (b == 0)
	        return 1 % c;
	   
	    long pow = (long)Mod(a, b/2, c);
	    int val;
	    if (b % 2 == 0){
	         val = (int)((long)((pow % c) * (pow % c)) % c);
	    } else {
	        val = (int)(((long)(a % c) * ((long)((pow % c) * (pow % c)) % c)) % c) ;
	        if (isneg){
	            val += c;
	        }
	    }
	    
	    return val;
	}
}

