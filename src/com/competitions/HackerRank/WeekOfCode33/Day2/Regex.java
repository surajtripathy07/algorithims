import java.util.*;

class Regex{

	static int process(String input){
		int bol = -1;
		int c = 0;
		int count = 0;
		while(c < input.length()){
			if (input.charAt(c) != '1' && input.charAt(c) != '0'){
				c++;
				// if anything other than 1 or 0 is encountered reset bol to -1
				bol = -1;
				continue;
			}

			// 1 has been encountered before
			if (bol > -1){
				if (input.charAt(c) == '0'){
					bol++;
					c++;
					continue;
				} else if (input.charAt(c) == '1'){
					if (bol > 0)
						count++;
					bol = 0;
					c++;
				}
			} else if (bol == -1 && input.charAt(c) == '1'){
				bol++;
				c++;
				continue;
			} else {
				c++;
			}
		}
		return count;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int queries = sc.nextInt();
		sc.nextLine();
		while(queries-- > 0){
			String ip = sc.nextLine();
			System.out.println(process(ip));
		}
	}
}
