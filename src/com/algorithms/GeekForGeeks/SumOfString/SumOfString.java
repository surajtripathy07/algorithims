import java.util.*;

class SumOfString{
	static Long sum;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		sum = 0L;
		String input = sc.next();
		allPerm(input, new StringBuilder(), 0);
		System.out.println("Sum is "+ sum);
	}

	static void allPerm(String ip, StringBuilder b, int i){
		if (i == ip.length()){
			try
			{
				sum += Long.parseLong(b.toString());
			} catch (NumberFormatException ex){
				// Skip	
			}
			return;
		}
		// With i-th char
		b.append(ip.charAt(i));
		allPerm(ip, b, i + 1);
		b.setLength(b.length() - 1);
		// Without i-th char
		allPerm(ip, b, i + 1);
	}
}
