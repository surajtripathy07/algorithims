import java.util.*;
public class Solution {
    public int automata(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c, int D, int E) {
        Set<Integer> acceptable = new HashSet<Integer>(c);
        c.clear();
        
        Set<String> perm = new HashSet<String>();
        allPermuteOfLen(0, E, null, perm);
        int count = 0;
        for (String p : perm){
            if (isAcceptable(p, a, b, acceptable, D)){
                System.out.println(p);
                count = (count % 100000007 + 1) % 100000007;
            }
        }
        return count;
    }
    
    public boolean isAcceptable(String automata, ArrayList<Integer> a, ArrayList<Integer> b, Set<Integer> c, Integer start){
        
        int state = start;
        for (int i = 0; i < automata.length(); i++){
            Character ch = automata.charAt(i);
            if (ch.equals('0')){
                state = a.get(state);
            } else {
                state = b.get(state);
            }
        }
        
        return c.contains(state);
    }
    
    public void allPermuteOfLen(int cur, int E, StringBuilder b, Set<String> perm){
     /*   if (b == null){
            b = new StringBuilder();
        }
        if (cur == E){
            perm.add(b.toString());
            return;
        }
        b.append(0);
        allPermuteOfLen(cur + 1, E, b, perm);
        b.setLength(b.length() - 1);
        b.append(1);
        allPermuteOfLen(cur + 1, E, b, perm);
        b.setLength(b.length() - 1);
    }
    */
    	for(int i = 0; i < Math.pow(2,E); i++)         
    	{    
    	    String format="%0"+E+"d";
    	    perm.add(String.format(format,Integer.valueOf(Integer.toBinaryString(i))));
    	}
    }

    public static void main(String args[]){
        Solution s = new Solution();
        Integer[] A = {0, 2, 1};
        Integer[] B = {1, 0, 2};
        Integer[] C = {0};

        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(A));
        ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(B));
        ArrayList<Integer> c = new ArrayList<Integer>(Arrays.asList(C));
        int D = 0;
	int N = 1;

	System.out.println(s.automata(a, b, c, D, N));
    }
}

