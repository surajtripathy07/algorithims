public class Solution {
    Set<Integer> vals;
	public int diffPossible(final List<Integer> a, int k) {
	    vals = new HashSet<Integer>(a.size());
	    vals.add(a.get(0));
	    for (int i = 1; i < a.size(); i++){
	        int diff = k + a.get(i);
	        if (vals.contains(diff)){
	            return 1;
	        }
	        diff = a.get(i) - k;
	        if (vals.contains(diff)){
	            return 1;
	        }
	        vals.add(a.get(i));
	    }
	    return 0;
	}
}

