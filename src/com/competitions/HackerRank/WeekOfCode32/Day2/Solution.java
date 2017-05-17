import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int getMaxMonsters(int n, int hit, int t, Integer[] h){
        // Complete this function
        Double tDoub = (double)hit;
	List<Integer> sortedH = new ArrayList<Integer>();
	for (int index = 0; index < h.length; index++)
	{
	    sortedH.add(h[index]);
	}        
        Collections.sort(sortedH, new Comparator<Integer>(){
            @Override
           public int compare(Integer a, Integer b){
               return Double.compare(Math.ceil(a/tDoub), Math.ceil(b/tDoub));
           } 
        });
        int kills = 0;
        int i = 0;
        while(t > 0){
            int timetokill = (int)Math.ceil(sortedH.get(i)/tDoub);
	    System.out.println(timetokill+" "+sortedH.get(i)+" "+tDoub);
            if (timetokill <= t){
                t -= timetokill;
                kills++;
            } else {
                t = 0;
            }
            i++;
        }
        
        return kills;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int hit = in.nextInt();
        int t = in.nextInt();
        Integer[] h = new Integer[n];
        for(int h_i=0; h_i < n; h_i++){
            h[h_i] = in.nextInt();
        }
        int result = getMaxMonsters(n, hit, t, h);
        System.out.println(result);
    }
}

