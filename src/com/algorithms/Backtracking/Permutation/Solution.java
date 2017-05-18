public class Solution {
    static ArrayList<ArrayList<Integer>> sol;
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    if (a.isEmpty()){
	        return null;
	    }
	    sol = new ArrayList<ArrayList<Integer>>();
	    permuter(a, 0, a.size());
	    return sol;
	}
	
    void permuter(ArrayList<Integer> a, int i, int size){
        int j;
        if (i == size){
                add(a);
        } else {
                for (j = i; j < size; j++){
                        a = swap(i, j, a);
                        permuter(a, i + 1, size);
                        // backtrack
                        a = swap(i, j, a);
                }
        }
    }
    
    public static void add(ArrayList<Integer> a){
        ArrayList<Integer> na = new ArrayList<Integer>(a);
        
        sol.add(na);
    }
    
    public ArrayList<Integer> swap(int i, int j, ArrayList<Integer> a){
        if (a.get(i) != a.get(j)){
            int temp = a.get(i);
            a.set(i, a.get(j));
            a.set(j, temp);
        }
        return a;
    }

}

