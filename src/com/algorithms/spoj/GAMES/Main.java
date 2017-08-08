import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		
		while(testCases-- > 0)
		{
			String number = sc.next();
			String[] num = number.split("\\.");
			if (num.length > 1)
			{
				int len = num[1].length();
				Long l = Long.parseLong(num[1]);
				Long mod = (long)(double)Math.pow(10, len);
				long originalL = l;
				// lcm of decimal(x) and powerOf10(y) = x * y / gcd(x,y)
				// now lcm(x,y) / x gives us our answer.
				System.out.println(mod / gcd(originalL, mod));
			}
			else
			{
				System.out.println(1);
			}
		}
	}

	public static long gcd(long a, long b)
	{
		if (b == 0)
			return a;
		return gcd(b, a%b);
	}
}

