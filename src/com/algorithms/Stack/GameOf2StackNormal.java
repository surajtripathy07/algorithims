import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
// Game of two stack
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfGames = in.nextInt();
        for(int i = 0; i < numberOfGames; i++){
            int sizeOfA = in.nextInt();
            int sizeOfB = in.nextInt();
            long maxSum = in.nextInt();
            int[] a = new int[sizeOfA];
            for(int j=0; j < sizeOfA; j++){
                a[j] = in.nextInt();
            }
            int[] b = new int[sizeOfB];
            for(int j=0; j < sizeOfB; j++){
                b[j] = in.nextInt();
            }
            // your code goes here
            int topA = 0, topB = 0, score = 0;
            long currMax = 0;
            while((topA < a.length && currMax + a[topA] <= maxSum) 
                  || ( topB < b.length && currMax + b[topB] <= maxSum)){
                
                long nextMaxA = Long.MAX_VALUE;
                if (topA < a.length){
                    nextMaxA = currMax + a[topA];
                }
                long nextMaxB = Long.MAX_VALUE;
                if (topB < b.length){
                    nextMaxB = currMax + b[topB];
                }
                
                if(nextMaxA > nextMaxB){
                    topB++;
                    currMax = nextMaxB;
                } else {
                    topA++;
                    currMax = nextMaxA;
                }
                score++;
            }
            System.out.println(score);
        }
    }
}

