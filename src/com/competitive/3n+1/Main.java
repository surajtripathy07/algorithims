import java.util.*;

public class Main{
	public Long getMax(Long val){
		Long step = 1L;
		while(val != 1){
			if (val % 2 == 0){
				val = val/2;
			} else {
				val = (3*val) + 1;
			}
			step++;
		}
		return step;
	}

	public static void main(String[] args){
		Main t = new Main();
		Scanner sc = new Scanner(System.in);

		while(true) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int nFrom = from;
			int nto = to;
			if (to < from){
				int temp = to;
				to = from;
				from = temp;
			}
			Long max = -1L;
			for (int i = from; i <= to; i++){
				Long step = t.getMax((long)i);
				if (step > max){
					max = step;
				}
			}	
			System.out.println(nFrom + " " + nto + " " +max);
		}
	}
}
