import java.util.*;

public class DuplicateReverse{
	
	public static void main(String args[]){
		for (int i = 1; i < 1000; i++){
			String num = String.valueOf(i);
			String revnum = String.valueOf(2*i);
			if (num.equals(new StringBuilder(revnum).reverse().toString())){
				System.out.println(num);
			}
		}
	}
}
