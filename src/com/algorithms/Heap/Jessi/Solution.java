import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    int[] cookieSweetness;
    int heapSize;
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int numOfCookies = sc.nextInt();
        int maxSweetness = sc.nextInt();
        
        
        Solution s = new Solution();
        s.cookieSweetness = new int[numOfCookies];
        int count = 0;
        while(count < numOfCookies){
            s.cookieSweetness[count++] = sc.nextInt();
        }
        
        s.buildMinHeap(s.cookieSweetness);
        s.heapSize = numOfCookies;
        count = 0;
        //displayArr(s.cookieSweetness, s.heapSize);
        while(count < numOfCookies - 1 && s.cookieSweetness[0] <= maxSweetness){
            ++count;
            int firstMin = s.extractMin(s.cookieSweetness, s.heapSize);
            s.heapSize--;
            int secondMin = s.getMin(s.cookieSweetness, s.heapSize);
            int newMin = firstMin + 2 * secondMin;
            
            s.addNewCookie(s.cookieSweetness, s.heapSize, newMin);
            //System.out.println(newMin);
            //System.out.println(s.cookieSweetness[0]);
            //displayArr(s.cookieSweetness, s.heapSize);
            System.out.println(count);
        }
        
        int output = -1;
        //System.out.println(s.cookieSweetness[0]);
        if (s.cookieSweetness[0] >= maxSweetness){
            output = count;
        }
        
        System.out.println(output);
    }
    
    public static void displayArr(int[] arr, int to)
        {
                for(int i = 0; i < to; i++)
                {
                    int ab = arr[i];
                    System.out.print(ab + " ");
                }
                System.out.println();
        }
    
    public void addNewCookie(int[] cookieSweetness, int heapSize, int newMin){
        cookieSweetness[0] = newMin ;
        minHeapify(cookieSweetness, 0, heapSize);
    }
    
    public void buildMinHeap(int[] cookieSweetness){
        for ( int i = (cookieSweetness.length)/2 - 1; i >= 0; i-- ){
            minHeapify(cookieSweetness, i , cookieSweetness.length);
        }
    }
    
    public int extractMin(int[] A, int heapSize)
	{
		int min = A[0];
		swap(0, heapSize - 1, A);
		minHeapify(A, 0, heapSize);
		return min;
	}
    
    public int getMin(int[] A, int heapSize){
        int min = A[0];
        return min;
    }
    
    public int[] minHeapify(int[] heap, int i, int heapSize){
	    if (i < heapSize/2){
        	int currIndex = i;
        	int leftChild = leftChild(heap, i, heapSize - 1);
        	int rightChild = rightChild(heap, i, heapSize - 1);
        	if (leftChild != -1 && heap[currIndex] > heap[leftChild]){
        	    currIndex = leftChild;
        	}
        	if (rightChild != -1 && heap[currIndex] > heap[rightChild]){
        	    currIndex = rightChild;
        	}
        	
        	if (currIndex != i){
		        if (heap[currIndex] != heap[i]){
			    //System.out.println("Swapping "+currIndex+" val "+heap[currIndex]+" with "+i+" val "+heap[i]);
			         heap = swap(currIndex, i, heap);
		        }
        	    minHeapify(heap, currIndex, heapSize);
        	}
	    }
        return heap;
    }
    
      public int leftChild(int[] heap, int parent, int heapSize){
        int childIndex = 2*parent + 1;
        if (childIndex < heapSize)
            return childIndex;
        else
            return -1;
    }
    
    public int rightChild(int[] heap, int parent, int heapSize){
        int childIndex = 2*parent + 2;
        if (childIndex < heapSize)
            return childIndex;
        else
            return -1;
    }

    public int[] swap(int i, int j, int[] heap){
	   int temp = heap[i];
	   heap[i] = heap[j];
	   heap[j] = temp;
	   return heap;

    }
}
