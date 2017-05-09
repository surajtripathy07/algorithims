import java.util.*;
class permute{
	int count = 0;
	public static void main(String args[]){
		permute p = new permute();
		int[] arr = {1, 2, 3, 4};
		//p.permuter(arr,0,4);
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(0);
		l.add(1);
		//l.add(2);
		l.add(5);
		p.printVal(l, 1, 0, 0, 0, 2);
		System.out.println("Num more than 21 are "+ p.count);
	}

	void permuter(int[] a, int i, int size){
		int j;
//		System.out.println("Here for arr from "+i+" to "+size);
		if (i == size){
			Util.display(a);
//			System.out.println("display");
//			System.out.println();
		} else {
			// 4 {3 5 8}, 3 {4 5 8}, 5 {3 4 8}, 8 {3 5 4}
			// 4 3 {5 8}, 4 5 {3 8},..
			// 4 3 {8 5}, 4 5 {8 3},..
			for (j = i; j < size; j++){
				a = Util.swap(i, j, a);
//				System.out.println("swapped "+i+" "+j);
				permuter(a, i + 1, size);
				// backtrack
				a = Util.swap(i, j, a);
//				System.out.println("swapped back "+i+" "+j);
//				System.out.println("returning");
			}
		}
		
	}

	public void printVal(ArrayList<Integer> A, int B, int pos, int val, int depth, int max){
        	if (depth == B){
			if (val < max){
				count++;
			}
        	    System.out.println(val);
		    return;
        	}
        
        	for (int i = pos; i < A.size(); i++){
		   if (depth == 0 && A.get(i) == 0){
			continue;
		   }
        	    val = val * 10 + A.get(i);
        	    printVal(A, B, pos, val, depth + 1, max);
		    val /= 10;
        	}
    	}
}
