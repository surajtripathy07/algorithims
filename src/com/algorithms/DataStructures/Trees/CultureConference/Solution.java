import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    int[] employee ;
    int[] isburned;
    int[] cultureP;
    public int getMinimumEmployees(Object[] adjecencyList){
        Map<Integer, Integer> processed = new HashMap<Integer, Integer>();
        // Iterate the entire tree
        for (int i = 0; i < employee.length; i++){    
            // Fill the list of nodes which are affected around i'th node
            ArrayList<Integer> affectedN = new ArrayList<Integer>();
            
            // Add self as affected if i is burned node
            if (isburned[i] == 1){
                affectedN.add(i);
            }
            // Add superviser as affected if superviserI is burned node
            int superviserI = employee[i];
            if (superviserI != i && isburned[superviserI] == 1){
                affectedN.add(superviserI);
            }
            // fetch childs of i'th node
            ArrayList<Integer> childI = (ArrayList<Integer>)adjecencyList[i];
            
            if (childI != null){
                // Add childs as affected if child is burned node
                for(Integer child : childI){
                    if (isburned[child] == 1){
                        affectedN.add(child);
                    }
                }
            }
            
            // Iterate affected nodes and change culture eligible node
            for( Integer aff : affectedN){
                // if node is already processed, add it in this group only if it will be 
                // part of a bigger group.
                if (processed.containsKey(aff)){
                        if (affectedN.size() > processed.get(aff)){
                            processed.put(aff, affectedN.size());
                            cultureP[aff] = i;
                        }
                } else {
                    processed.put(aff, affectedN.size());
                    cultureP[aff] = i;
                }
            }
        }
        // Iterate the culture array and identify unique groups
        Set<Integer> rep = new HashSet<Integer>();
        for (Integer i : cultureP){
            if (i != -1){
                rep.add(i);
            }
        }
        return rep.size();
    }
    
    public void initialize(){
        for (int i = 0; i < cultureP.length; i++){
            cultureP[i] = -1;
        }
    }
    

    public static void main(String[] args) {
        Solution sc = new Solution();
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        sc.employee = new int[n];
        sc.isburned = new int[n];
        sc.cultureP = new int[n];
        sc.initialize();
        
        Object[] adjecencyList = new Object[n];
       	n--; 
        while(n > 0){
            int index = sc.employee.length - n--;
	    //System.out.println(index + " " + n);
            sc.employee[index] = in.nextInt();
            if (adjecencyList[sc.employee[index]] == null){
                adjecencyList[sc.employee[index]] = new ArrayList<Integer>();
            }
            // Adding child list 
            ((ArrayList<Integer>)adjecencyList[sc.employee[index]]).add(index);
            
            if (in.nextInt() == 0){
                sc.isburned[index] = 1;
            }
        }
        int minimumEmployees = sc.getMinimumEmployees(adjecencyList);
        System.out.println(minimumEmployees);
    }
}

