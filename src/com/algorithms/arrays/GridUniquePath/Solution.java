import java.util.*;

public class Solution {
    boolean grid[][];
    int count;
    int posmovex[] = {1, 0};
    int posmovey[] = {0, 1};
    
    public static class Pair{
        public int x;
        public int y;
        
        public int level;
        public Pair(int x, int y, int level){
            this.x = x;
            this.y = y;
            this.level = level;
        }
        
        public boolean equals(Pair p){
            return this.x == p.x && this.y == p.y;
        }
        
        public int hashCode(){
            return 31 * x + y & 0x7fffffff;
        }
    }
    
	public int uniquePaths(int a, int b) {
	    Queue<Pair> queue = new LinkedList<Pair>();
	    int startx = 0, starty = 0;
	    int maxForLevel = 0;
	    for (int i = 0; i < posmovex.length; i++)
	    {
	        int newx = startx + posmovex[i];
	        int newy = starty + posmovey[i];
	        if (isvalidmove(newx, newy, a - 1, b - 1)){
	            queue.add(new Pair(newx, newy, 0));
	            maxForLevel++;
	        }
	    }
	    int level = 1;
	    int max = 0;
	    while(!queue.isEmpty()){
	        Pair p = queue.remove();
	        if (level != p.level){
	            level = p.level;
	            if (max > maxForLevel){
	                maxForLevel = max;
	            }
	            max = 0;
	        }
	        for (int i = 0; i < posmovex.length; i++)
    	    	{
    	        	int newx = p.x + posmovex[i];
    	        	int newy = p.y + posmovey[i];
			if (newx == a - 1 && newy == b - 1)
    	        	{
    	        	    continue;
    	        	}
    	        	if (isvalidmove(newx, newy, a - 1, b - 1)){
    	        	    queue.add(new Pair(newx, newy, p.level + 1));
    	        	    max++;
    	        	}
    	    	}
	    }
	    return maxForLevel;
	}
	
	public boolean isvalidmove(int newx, int newy, int endx, int endy){
	    return  0 <= newx && newx <= endx && 0 <= newy && newy <= endy;
	}
	
	public static void main(String args[]){
		Solution sc = new Solution();
		int a = sc.uniquePaths(6, 5);
		System.out.println(a);
	}
	
}

