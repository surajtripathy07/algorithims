import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static int twinArrays(int[] ar1, int[] ar2){
        // Complete this function
        int m1 = getMin(ar1, ar2);
        int m2 = getMin(ar2, ar1);
        return m1 > m2 ? m2 : m1;
    }
    
    static int getMin(int[] ar1, int[] ar2){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < ar1.length; i++){
            if (ar1[i] < min){
                min = ar1[i];
                index = i;
            }
        }
        
        int MIN = Integer.MAX_VALUE;
        for (int i = 0; i < ar2.length; i++){
            if (i != index && MIN > min + ar2[i]){
                MIN = min + ar2[i];
            }
        }
        return MIN;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar1 = new int[n];
        for(int ar1_i = 0; ar1_i < n; ar1_i++){
            ar1[ar1_i] = in.nextInt();
        }
        int[] ar2 = new int[n];
        for(int ar2_i = 0; ar2_i < n; ar2_i++){
            ar2[ar2_i] = in.nextInt();
        }
        int result = twinArrays(ar1, ar2);
        System.out.println(result);
    }
}

