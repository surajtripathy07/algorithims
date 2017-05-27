public class Solution {
    ArrayList<ArrayList<Integer>> set;
	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
	    set = new ArrayList<ArrayList<Integer>>();
	    set.add(new ArrayList<Integer>());
	    Collections.sort(a);
	    ArrayList<Integer> un = new ArrayList<Integer>();
	    /*un.add(a.get(0));
	    for(int i = 1; i < a.size(); i++){
	        if (a.get(i) != a.get(i - 1)){
	            un.add(a.get(i));
	        }
	    }*/
	    //subset(a,new ArrayList<Integer>(), a.size() - 1);
	    lsubset(a,new ArrayList<Integer>(), 0);
	    
	    Set<ArrayList<Integer>> uniqueSet = new HashSet<ArrayList<Integer>>();
	    for ( int i = 0; i < set.size(); i++){
	        uniqueSet.add(set.get(i));
	    }
	    set.clear();
	    set.addAll(uniqueSet);
	    uniqueSet.clear();
	    
	    // Lexicological Sort
	    Collections.sort(set, new Comparator<ArrayList<Integer>>(){
	       public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
	           if (a.size() < b.size()){
	               for (int i = 0; i < a.size(); i++){
	                   if (a.get(i) == b.get(i)){
	                       continue;
	                   }
	                   if (a.get(i) < b.get(i)){
	                       return -1;
	                   } else {
	                       return 1;
	                   }
	               }
	               return -1;
	           } else {
	               for (int i = 0; i < b.size(); i++){
	                   if (a.get(i) == b.get(i)){
	                       continue;
	                   }
	                   if (a.get(i) < b.get(i)){
	                       return -1;
	                   } else {
	                       return 1;
	                   }
	               }
	               
	               if (a.size() > b.size()){
	                   return 1;
	               }
	           }
	           return 0;
	       }
	    });
	    
	    return set;
	}
	public void lsubset(ArrayList<Integer> a, ArrayList<Integer> b, int i){
	    if (i == a.size()){
	        return;
	    }
	    b.add(a.get(i));
	    ArrayList<Integer> nb = new ArrayList<Integer>(b);
	    set.add(nb);
	    lsubset(a, b, i + 1);
	    b.remove(b.size() - 1);
	    lsubset(a, b, i + 1);
	}
	
	public void subset(ArrayList<Integer> a, ArrayList<Integer> b, int i){
	    if (i == -1){
	        return;
	    }
	    //without self
	    subset(a, b, i - 1);
	    
	    //with self
	    b.add(a.get(i));
	    if (!b.isEmpty()){
	        ArrayList<Integer> nb = new ArrayList<Integer>(b);
	        Collections.reverse(nb);
	        set.add(nb);
	    }
	    subset(a, b, i - 1);
	    
	    if (!b.isEmpty())
	        b.remove(b.size() - 1);
	}

}

