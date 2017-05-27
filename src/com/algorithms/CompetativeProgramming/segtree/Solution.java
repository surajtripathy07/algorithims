import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int noOfQ = sc.nextInt();
        int height = (int)(Math.ceil(Math.log(len)/Math.log(2)));
        int sizeOfSeg = 2*((int)(Math.pow(2, height))) - 1 ;
        long[] arr = new long[sizeOfSeg];
        long[] lazy = new long[sizeOfSeg];
        
        while(noOfQ-- > 0){
            int qstart = sc.nextInt();
            int qend = sc.nextInt();
            long increment = sc.nextLong();
            updateSeg(arr, lazy, qstart - 1, qend - 1, increment, 0, len - 1, 0);
        }
        
        System.out.println(arr[0]);
        
    }
    
      
    public static void updateSeg(long[] seg, long[] lazy, int qstart, int qend, long increment, int low, int high, int pos){
        
        if (low > high) {
            return;
        }
        
        // maintaining lazy propogation
        if (lazy[pos] != 0){
            seg[pos]+= lazy[pos];
            if (low != high){
                lazy[2*pos + 1] += lazy[pos];
                lazy[2*pos + 2] += lazy[pos];
            }
            lazy[pos] = 0;
        }
        
        // no overlap
        if (qstart > high || qend < low){
            return;
        }
        
        //total overlap
        if (qstart<= low && qend >= high){
            seg[pos]+=increment;
            if (low != high){
                lazy[2*pos + 1] += increment;
                lazy[2*pos + 2] += increment;
            }
            return;
        }
        
        // partial overlap
        int mid = (low + high)/2;
        updateSeg(seg, lazy, qstart, qend, increment, low, mid, 2*pos + 1);
        updateSeg(seg, lazy, qstart, qend, increment, mid + 1, high, 2*pos + 2);
        seg[pos] = Math.max(seg[2*pos + 1], seg[2*pos + 2]);
    }
}
