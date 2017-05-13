import java.util.*;
public class Solution {
    Map<String, Integer> visit = new HashMap<String, Integer>();
    StringBuilder buff = new StringBuilder();
	public int knight(int N, int M, int x1, int y1, int x2, int y2) {
		if (x1 == x2 && y1 == y2){
	        	return 0;
	    	}
	    ArrayList<ArrayList<Integer>> moves = getMoves(x1, y1, N, M);
	    int steps = -1;
	    for (int i = 0; i < moves.size(); i++){
	        ArrayList<Integer> move = moves.get(i);
		System.out.println("Going to process " +move.get(0)+" "+ move.get(1));
	        int s = moveKnight(N, M, move.get(0), move.get(1), x2, y2, -1);
	        if (s != -1 && (steps < 0 || steps > (s+1) ) ) {
	            steps = s + 1;
	        }
	    }
	    return steps;
	}
	
	public int moveKnight(int N, int M, int i, int j, int endI, int endJ, int steps){
	    //int key = i*10 + j;
	    String key = getKey(i, j);
	    int currentStep = -1;
	    if (visit.containsKey(key)){
    	    return  visit.get(key);
	    }
	    
	    if (i == endI && j == endJ){
	           return 0;
	    }
	    
	    visit.put(key, steps);
	    
	    ArrayList<ArrayList<Integer>> moves = getMoves(i, j, N, M);
	    
	    for (int k = 0; k < moves.size(); k++){
	        ArrayList<Integer> move = moves.get(k);
			System.out.println("Going to process in " +move.get(0)+" "+ move.get(1)+" child of "+key) ;
	        int s = moveKnight(N, M, move.get(0), move.get(1), endI, endJ, -1);
			System.out.println("Number of steps for " +move.get(0)+" "+ move.get(1) +" "+s);
	        if (s != -1) {
                // persist the calculated value
                //int skey = (10*move.get(0)+move.get(1));
                String skey = getKey(move.get(0),move.get(1));
                int curval = -1;
                if (visit.containsKey(skey)){
                    curval = visit.get(skey);
                }
                // update the value only  of skey if current path is better than previous
                if (curval < 0 || (curval > s && s == 0)){
                	System.out.println("Setting s to " +skey+ " s->" + s);
                    visit.put(skey, s);
                }
                
                // pick the shortest path form i,j node
                if (steps < 0 || steps > (s + 1)){
                	System.out.println("new steps for "+i +" "+j +"is " + (s + 1));
                    steps = s + 1;
                }
	        }
	    }
	    
	    // update shortest path in map
	    visit.put(key, steps);
	    
	    return steps;
	}
	
	// Returns List of position Knight can move from i, j
	public ArrayList<ArrayList<Integer>> getMoves(int i, int j, int N, int M){
	    ArrayList<ArrayList<Integer>> moves = new ArrayList<ArrayList<Integer>>(4);
	    int left = i - 2;
	    int right = i + 2;
	    int down = j - 2;
	    int up = j + 2;
	    boolean jleft = isjInLimit(j - 1, M);
	    boolean jright = isjInLimit(j + 1, M);
	    boolean ileft = isiInLimit(i - 1, N);
	    boolean iright = isiInLimit(i + 1, N);
	    if (isiInLimit(left, N)){
	        if (jleft){
	            ArrayList<Integer> move = new ArrayList<Integer>();
	            move.add(left);
	            move.add(j - 1);
	            moves.add(move);
	        }
	        if (jright){
	            ArrayList<Integer> move = new ArrayList<Integer>();
	            move.add(left);
	            move.add(j + 1);
	            moves.add(move);
	        }
	    }
	    
	    if (isiInLimit(right, N)){
	        if (jleft){
	            ArrayList<Integer> move = new ArrayList<Integer>();
	            move.add(right);
	            move.add(j - 1);
	            moves.add(move);
	        }
	        if (jright){
	            ArrayList<Integer> move = new ArrayList<Integer>();
	            move.add(right);
	            move.add(j + 1);
	            moves.add(move);
	        }
	    }
	    
	    if (isjInLimit(up, M)){
	        if (ileft){
	            ArrayList<Integer> move = new ArrayList<Integer>();
	            move.add(i - 1);
	            move.add(up);
	            moves.add(move);
	        }
	        if (iright){
	            ArrayList<Integer> move = new ArrayList<Integer>();
	            move.add(i + 1);
	            move.add(up);
	            moves.add(move);
	        }
	    }
	    
	    if (isjInLimit(down, M)){
	        if (ileft){
	            ArrayList<Integer> move = new ArrayList<Integer>();
	            move.add(i - 1);
	            move.add(down);
	            moves.add(move);
	        }
	        if (iright){
	            ArrayList<Integer> move = new ArrayList<Integer>();
	            move.add(i + 1);
	            move.add(down);
	            moves.add(move);
	        }
	    }
	    
	    return moves;
	}
	
	public boolean isiInLimit(int i, int N){
	    return  1 <= i && i <= N;
	}
	
	public boolean isjInLimit(int i, int M){
	    return  1 <= i && i <= M;
	}
	
	public String getKey(int i , int j){
		buff.setLength(0);
		buff.append(String.valueOf(i));
		buff.append(String.valueOf(j));
		return buff.toString();
	}
	
	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);
		Solution s = new Solution();
		int steps = s.knight(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		System.out.println(steps);
	}
}

