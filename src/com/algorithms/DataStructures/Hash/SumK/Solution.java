public class Solution {
    Map<Integer, Integer> pair;
	public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
	    ArrayList<Integer> result = new ArrayList<Integer>(2);
	    pair = new HashMap<Integer, Integer>(a.size());
	    pair.put(a.get(0), 0);
	    for (int i = 1; i < a.size(); i++){
	        int dif = b - a.get(i);
	        if (pair.containsKey(dif)){
	            result.add(pair.get(dif) + 1);
	            result.add(i + 1);
	            return result;
	        } else if (!pair.containsKey(a.get(i))){
	            pair.put(a.get(i), i);
	        }
	    }
	    return result;
	}
}

