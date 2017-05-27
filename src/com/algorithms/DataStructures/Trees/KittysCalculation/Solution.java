import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public int[] tree;
    public int[] depth;
    public final int MODULO = 1000000007;
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int queries = sc.nextInt();
        //queries *= 2;
        
        Solution s = new Solution();
        s.tree = new int[nodes];
        s.depth = new int[nodes];
        
        s.initialize();
        
        while(nodes-- > 1){
            s.union(sc.nextInt() - 1, sc.nextInt() - 1);
        }
        while(queries-- > 0){
            int len = sc.nextInt();
            //System.out.println(len);
            int[] set = new int[len];
            for (int i = 0; i < len; i++){
                set[i] = sc.nextInt() - 1;
            }
            System.out.println(s.calculate(set));
        }
        
    }
    
    public void union(int u, int v){
        tree[v] = u;
        depth[v] = (1 + depth[u]);
    }
        
    public void initialize(){
        for( int i = 0; i < tree.length; i++){
            tree[i] = i;
        }
    }
    
    public int calculate (int[] set){
        if (set.length < 2){
            return 0;
        }
        
        long sum = 0;
        for(int i = 0; i < set.length; i++){
            for(int j = i + 1; j < set.length; j++){
		      //System.out.println("Going to process for Set {"+(i+1)+","+(j+1)+"}");
		      int dist = dist(set[i], set[j]);
		      //System.out.println("New add val is "+"("+(set[i] + 1)+" * "+(set[j] + 1)+" * "+dist+")");
                sum += ((set[i] + 1) * (set[j] + 1) * dist) % MODULO ;
            }
        }
        return (int)(sum % MODULO);
    }
    
    public int dist(int u, int v){
        int count = 0;
        int steps = 0;
        int diff = 0;
        //System.out.print("for "+(u + 1)+" and "+(v+1));
        
        // If the nodes are on different depth, then
        // bring them on same depth, cause 
        // a lowest ancestor will always have depth at most min(depth of u or depth of v).
        if ( depth[u] > depth[v]){
            diff = depth[u] - depth[v];
            count = diff;
            while(count-- > 0){
                u = tree[u];
            }
        } else if(depth[v] > depth[u]){
            diff = depth[v] - depth[u];
            count = diff;
            while(count-- > 0){
                v = tree[v];
            }
        }
        
        // Once equal depth is achieved, walk both node simultaneously,
        // and check if ancestor is reached.
        while(u != v){
            u = tree[u];
            v = tree[v];
            steps += 2;
        }
        
        //System.out.println(" steps is "+(steps + diff));
        return steps + diff;
    }
}
