import java.math.BigInteger;
import java.util.*;
public class Solution {
    Map<Integer, BigInteger> mem = new HashMap<Integer, BigInteger>();
    
	public int uniquePaths(int a, int b) {
	    if (a == 1 || b == 1){
		return 1;
	    }
	    BigInteger numX = new BigInteger(String.valueOf((a - 1)));
	    BigInteger numY =  new BigInteger(String.valueOf((b - 1)));
	   
	    BigInteger paths = factor(new BigInteger(String.valueOf(a+b-2))).divide(factor(numX).multiply(factor(numY)));
	    
	    return (int)paths.intValue();
	}
	
	public BigInteger factor(BigInteger fact){
	    if (mem.containsKey(fact.intValue())){
	        return mem.get(fact.intValue());
	    }
	    if (fact.compareTo(BigInteger.ONE) <= 0){
	        return new BigInteger("1");
	   }
	    else {
		int end = fact.intValue();
		mem.put(1, new BigInteger("1"));
		for (int i = 2; i <= end; i++){
	        	BigInteger f = mem.get(i-1).multiply(new BigInteger(String.valueOf(i)));
		        mem.put(i, f);
		}
	        return mem.get(end);
	    }
	}

}

	  public static void main(String args[]){
                Solution sc = new Solution();
                int a = sc.uniquePaths(15, 12);
                System.out.println(a);
        }

}

