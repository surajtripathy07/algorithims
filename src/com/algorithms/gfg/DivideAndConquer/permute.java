import java.util.*;
class permute{
	int count = 0;
	
    ArrayList<ArrayList<Integer>> perm = new ArrayList<ArrayList<Integer>>();
	public static void main(String args[]){
		permute p = new permute();
		int[] arr = {1, 2, 3, 4};
		//p.permuter(arr,0,2);
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(0);
		l.add(1);
		//l.add(2);
		l.add(5);
//		p.printVal(l, 1, 0, 0, 0, 2);
		//System.out.println("Num more than 21 are "+ p.count);
		p.combine0(0, arr, 2, 0);
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
				//a = Util.swap(i, j, a);
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

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		return null;    
	}
	
	public void combine(int i, int[] a, int size){
	    if (i == size){
	        add(a, size);
	        return;
	    }
	    
	    for (int j = i; j < a.length; j++){
		//System.out.println("swapped "+i+" "+j);
	        a = Util.swap(i, j, a);
	        combine(i + 1,a, size);
	        a = Util.swap(i, j, a);
	    }
	}

        public void combine0(int i, int[] a, int size, int depth){
            if (i == size-1){
                add(a, size);
                return;
            }
		if (depth == size){
                        return;
                }


            for (int j = i; j < a.length; j++){
                //System.out.println("swapped "+i+" "+j);
                a = Util.swap(i, j, a);
                combine0(j,a, size, depth + 1);
                a = Util.swap(i, j, a);
            }
        }

	
	public void add(int[] a, int size){
	    ArrayList<Integer> l = new ArrayList<Integer>();
	    for (int i = 0; i < size - 1; i++){
		if (a[i] > a[i + 1]){
			return;
		}
	    }
		for (int i = 0; i < size; i++){	
			System.out.print(a[i]+ " ");
//		     l.add(a[i]);
		}
		
//	    perm.add(l);
		System.out.println();
	}

}
