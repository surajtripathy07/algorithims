import java.util.*;
class fact{

	public static void main(String args[]){
		System.out.println((fact(20, new HashMap<Long, Long>())) / 10000000);
	}

	public static long fact(long num, Map<Long, Long> mem){
		if (num == 1){
			return 1;
		}
		if (mem.containsKey(num)){
			return mem.get(num);
		} else {
			mem.put(num,  num * fact(num - 1, mem));
			return mem.get(num);
		}
		
	}
}
