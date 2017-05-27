public class Solution {
	public int divide(int dividend, int divisor) {
	    long n = dividend, m = divisor;
        // determine sign of the quotient
        int sign = n < 0 ^ m < 0 ? -1 : 1;
    
        // remove sign of operands
        n = Math.abs(n); m = Math.abs(m);
    
        // q stores the quotient in computation
        long q = 0;
    
        // test down from the highest bit
        // accumulate the tentative value for valid bits
        for (long t = 0, i = 31; i >= 0; i--){
            long shift = m<<i;
            long sum = t + (m << i);
            System.out.print("t is "+ Long.toBinaryString(t) +
            " and m << i is "+Long.toBinaryString(shift)+" and t + m << i is "
            + (sum)+" in binary "+Long.toBinaryString(sum)+" and N is "+n+"----------");
            if (sum <= n) {
                t += shift;
                System.out.print("q is updated from "+Long.toBinaryString(q)+" to ");
                q |= 1L << i;
                System.out.print(Long.toBinaryString(q)+"------");
            }
        }
    
        // assign back the sign
        if (sign < 0) q = -q;
    
        // check for overflow and return
        return (q >= Integer.MAX_VALUE || q < Integer.MIN_VALUE) ? Integer.MAX_VALUE : (int)q;
	}
}

