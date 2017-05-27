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
	    score = playGame(a, b, topA, topB, maxSum, 0L, new HashMap<String, Integer>());
	    System.out.println(score);
	     
        }
    }

	public static int playGame(int[] a, int[] b, int topA, int topB, long maxSum, long currSum, Map<String, Integer> mem){
		int scoreA = 0, scoreB = 0;
		if (topA < a.length && currSum + a[topA] > maxSum){
			//can't go ahead from here	
		} else if (topA < a.length){
			//String key = "A"+topA;
			//if(mem.containsKey(key)){
			//	scoreA = mem.get(key);
			//} else {
				scoreA = 1 + playGame(a, b, topA + 1, topB, maxSum, currSum+a[topA], mem);
			//	mem.put(key, scoreA);
			//}
		}
		if (topB < b.length && currSum + b[topB] > maxSum){
			//cant get ahead from here
		}else if (topB < b.length){
			//String key = "B"+topB;
			//if(mem.containsKey(key)){
                        //        scoreB = mem.get(key);
                        //} else {
				scoreB = 1 + playGame(a, b, topA, topB+1, maxSum, currSum+b[topB], mem);
			//	mem.put(key, scoreB);
			//}
		}
		return Math.max(scoreA, scoreB);
	}
}

