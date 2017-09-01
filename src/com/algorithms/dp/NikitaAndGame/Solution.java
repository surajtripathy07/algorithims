import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            while(n > 0){
                arr[arr.length - n--] = sc.nextInt();
            }
            
            System.out.println(maxScore(arr, 0, arr.length - 1));
        }
    }
    
    public static int maxScore(int[] arr, int left, int right){
        int partition = canScore(arr, left, right, arr[left], arr[right]);
	System.out.println("Partitioned at "+partition);
        if (partition == -1) return 0;
        else 
            return 1 + Math.max(maxScore(arr, left, partition), maxScore(arr, partition + 1, right));
    }
    
    public static int canScore(int[] arr, int  left, int right, int lSum, int rSum){
        if (right <= left){
            return -1;
        }
        if (left == right - 1 ){
            if (lSum == rSum){
                return left;
            } else {
                return -1;
            }
        }
        if (lSum > rSum ){
            return canScore(arr, left, right - 1, lSum, rSum + arr[right - 1]);
        } else {
            return canScore(arr, left + 1, right, lSum + arr[left + 1], rSum);
        }
    }
    
    
}

