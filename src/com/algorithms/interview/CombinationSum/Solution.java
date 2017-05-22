import java.util.*;
public class Solution {
    ArrayList<ArrayList<Integer>> perm = new ArrayList<ArrayList<Integer>>();
    //int curpos = -1;
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
	    Collections.sort(a);
        HashSet<Integer> uSet = new HashSet<Integer>(a);
        a = new ArrayList<Integer>(uSet);
        Collections.sort(a);

	    combine(a, 0, b, 0, new ArrayList<Integer>());
	    return perm;
	}
	
	public ArrayList<Integer> combine(ArrayList<Integer> a, int pos, int maxsum, int sum, ArrayList<Integer> curr){
	    if (sum == maxsum){
	        perm.add(curr);
		//System.out.println("added "+curr);
		curr = new ArrayList<Integer>(curr);
	        return curr;
	    } else if (sum > maxsum){
	        return curr;
	    }
	    
	    for (int i = pos; i < a.size(); i++){
		//System.out.println("Added "+a.get(i));
	        curr.add(a.get(i));
	        
	        curr = combine(a, i, maxsum, sum + a.get(i), curr);
	        
	        if (!curr.isEmpty()){
	            int val = curr.remove(curr.size() - 1);
                    //System.out.println("removed"+a.get(i));
	        }
	    }
	    return curr;
	}

	public static void main(String args[]){
		Solution s = new Solution();
		ArrayList<Integer> ab = new ArrayList<Integer>();
		ab.add(1);
		ab.add(2);
		ArrayList<ArrayList<Integer>> a = s.combinationSum(ab, 10);
		for (ArrayList<Integer> i : a){
			System.out.print("[ ");
			for(Integer x : i){
				System.out.print(x+" ");
			}
			System.out.println("], ");
			
		}
	}
}

