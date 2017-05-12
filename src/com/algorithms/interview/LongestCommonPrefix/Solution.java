public class Solution {
    StringBuilder b = new StringBuilder();
	public String longestCommonPrefix(ArrayList<String> a) {
	    if (a.isEmpty()){
	        return "";
	    }
	    int index = getMinLen(a) - 1;
	    int low = 0, high = index;
	    StringBuilder prefix = new StringBuilder();
	    while(low <= high){
	        int mid = low + (high - low)/2;
	        if (matches(a, low, mid, a.get(0))){
	            prefix.append(b);
	            low = mid + 1;
	        } else {
	            high = mid - 1;
	        }
	    }
	    return prefix.toString();
	}
	
	public boolean matches(ArrayList<String> a, int start, int end, String specimin){
	    b.setLength(0);
	    for (String str : a){
	        for (int i = start; i <= end; i++){
	            if (str.charAt(i) != specimin.charAt(i)){
	                return false;
	            }   
	        }
	    }
	    for (int i = start; i <= end; i++){
	            b.append(specimin.charAt(i));
	    }
	    return true;
	}
	
	public int getMinLen(ArrayList<String> a) {
	    if (a.isEmpty())
	        return -1;
	        
	    int min = a.get(0).length();
	    for (String s : a){
	        if (min > s.length())
	            min = s.length();
	    }
	    return min;
	}
}

