import java.io.*;
import java.util.*;

public class Solution {
    int[] unionSet;
    long[] size;
    Set<Integer> roots;
    int sizer;
    public void initialize(){
        for (int i = 0; i < unionSet.length; i++){
            unionSet[i] = i;
            size[i] = 1;
            //roots.add(i);
        }
    }
    
    public void union(int d, int v){
        if (d == v){
            return;
        }
        // Number of nodes which are part of a larger community
        if (unionSet[d] == d && !roots.contains(d)){
            sizer++;
        }
        if (unionSet[v] == v && !roots.contains(v)){
            sizer++;
        }
        
        int rootD = getRoot(d);
        int rootV = getRoot(v);
        if (rootV == rootD){
            return;
        }
       // System.out.println("Initial Size of "+rootD+ " is "+size[rootD]);
        //System.out.println("Initial Size of "+rootV+ " is "+size[rootV]);
        if (size[rootD] > size[rootV]){
            unionSet[rootV] = rootD;
            size[rootD] += size[rootV];
            if (roots.contains(rootV)){
                roots.remove(rootV);
            }
            roots.add(rootD);
            
        } else {
            unionSet[rootD] = rootV;
            size[rootV] += size[rootD];            
            if (roots.contains(rootD)){
                roots.remove(rootD);
            }
            roots.add(rootV);
        }
    }
    
    public int getRoot(int i){
        while(unionSet[i] != i){
            unionSet[i] = unionSet[unionSet[i]];
            i = unionSet[i];
        }
        return i;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        s.roots = new HashSet<Integer>();
        int numbOfPeople = sc.nextInt();
        s.sizer = 0;
        s.unionSet = new int[numbOfPeople];
        s.size =  new long[numbOfPeople];
        s.initialize();
        int numOfPair = sc.nextInt();
        
        while(numOfPair-- > 0){
            s.union(sc.nextInt(), sc.nextInt());
        }
        int numOfPeopleLeft = numbOfPeople - s.sizer;
        long totalCombinationOfLeft = ((long)(numOfPeopleLeft) * (long)(numOfPeopleLeft - 1)) / 2;
        //System.out.println("TotalComb "+totalCombinationOfLeft+" ppl left "+numOfPeopleLeft);
        ArrayList<Integer> rootArr = new ArrayList<Integer>(s.roots);
        long tot = 0;
        //System.out.println("Total roots "+rootArr.size());
        
        for (int i = 0; i < rootArr.size(); i++){
            tot += ((long)s.size[rootArr.get(i)] * numOfPeopleLeft);
            //System.out.println("For group with root "+rootArr.get(i)+" size is "+s.size[rootArr.get(i)]);
            for (int j = i + 1; j < rootArr.size();j++){
               // System.out.println("For group with root "+rootArr.get(i)+" and group with root "+rootArr.get(j)+" tot is "+((long)s.size[rootArr.get(i)]) * ((long)s.size[rootArr.get(j)]));
                tot += ((long)s.size[rootArr.get(i)]) * ((long)s.size[rootArr.get(j)]);
            }
        }
        
        System.out.println(tot+totalCombinationOfLeft);
    }
}
