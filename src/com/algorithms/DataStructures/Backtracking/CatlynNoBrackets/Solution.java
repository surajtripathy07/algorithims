public class Solution {
    ArrayList<String> allpar;
    StringBuilder b ;
	public ArrayList<String> generateParenthesis(int a) {
	    allpar = new ArrayList<String>();
	    if (a < 1){
	        return allpar;
	    }
	    if (a == 1){
	        allpar.add("()");
	        return allpar;
	    }
	    
	    b = new StringBuilder(2*a);
	    for (int i = 0; i < 2*a; i++){
	        b.append('1');
	    }
	    
	    paren(0, a, 0, 0);
	    Collections.reverse(allpar);
	    return allpar;
	}
	
	public void paren(int i, int n, int open, int close ){
	    if (close == n){
	        allpar.add(b.toString());
	        return;
	    }
	    if (open > close){
	        b.setCharAt(i, ')');
	        paren(i+1, n, open, close + 1);
	    }
	    if (open < n){
	        b.setCharAt(i, '(');
	        paren(i+1, n, open + 1, close);
	    }
	}
	
	/*
	public ArrayList<String> paren(int a){
	    if (a == 1){
	        ArrayList<String> s = new ArrayList<String>();
	        s.add("()");
	        return s;
	    }
	    ArrayList<String> s = paren(a - 1);
	    ArrayList<String> ns = new ArrayList<String>();
	    
	    // Surround with ( )
	    for (int i = 0; i < s.size(); i++){
	        b.setLength(0);
	        b.append("(");
	        b.append(s.get(i));
	        b.append(")");
	        String newP = b.toString();
	        if (!ns.contains(newP)){
	            ns.add(newP);
	        }
	    }
	    
	    // Place self left right
	    String self = "()";
	    for (int i = 0; i < s.size(); i++){
	        
	        b.setLength(0);
	        b.append(s.get(i)).append(self);
	        String newP = b.toString();
	        if (!ns.isEmpty() && !ns.contains(newP)){
	            ns.add(newP);
	        }
	        
	        b.setLength(0);
	        b.append(self).append(s.get(i));
	        newP = b.toString();
	        if (!ns.isEmpty() && !ns.contains(newP)){
	            ns.add(newP);
	        }
	    }
	    
	    return ns;
	}*/
}

