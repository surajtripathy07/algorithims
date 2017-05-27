public class Power{

	public static void main(String args[]){
		Power p = new Power();
		long var = Util.nextInt();
		long pow = Util.nextInt();
		long start = System.currentTimeMillis();
		System.out.println(p.getPow(var, pow));
		long end = System.currentTimeMillis();
		System.out.println("Time taken = " + (end - start) + "ms");
		start = System.currentTimeMillis();
                System.out.println(p.getPower(var, pow));
		end = System.currentTimeMillis();
                System.out.println("Time taken = " + (end - start) + "ms");
	}

	// O(n)
	public long getPow(long var, long pow){
		if (pow == 0){
			return 1;
		}
		if (pow % 2 == 0){
			return getPow(var, pow/2) * getPow(var, pow/2);
		} else {
			return var * getPow(var, pow/2) * getPow(var, pow/2);
		}
	}

	//O(logn)
	public long getPower(long var, long pow){
		if (pow == 0){
			return 1;
		}
		long temp = getPower(var, pow/2);
		if (pow % 2 == 0){
                        return temp * temp;
                } else {
                        return var * temp * temp;
                }
	}

}
