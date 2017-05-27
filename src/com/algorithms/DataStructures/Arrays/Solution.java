import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int q = sc.nextInt();
       int sequenceArray[][] = new int[n][q];
       int index[] = new int[n];
       int lastAns = 0;
       while(sc.hasNext()){
           int flag = sc.nextInt();
           int x = sc.nextInt();
           int y = sc.nextInt();
           int resIndex = (x ^ lastAns) % n;
           if(flag == 1){
		System.out.println("adding val in seq "+resIndex+" at pos "+index[resIndex]+" value "+y);
               sequenceArray[resIndex][index[resIndex]] = y;
               index[resIndex]++;
		System.out.println(index[resIndex]);
           } else {
               int lastAnsIndex = y % index[resIndex];
               lastAns = sequenceArray[resIndex][lastAnsIndex];
               System.out.println(lastAns);
           }
       }
	for (Integer i : sequenceArray){
		for (Integer j : sequenceArray[i]){
			System.out.print(sequenceArray[i][j]+"  ");	
		}
		System.out.println();
	}
   }
}

