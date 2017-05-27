import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QHeap{
    public int heapSize;
    public long[] heap;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	Scanner sc = new Scanner(System.in);
	QHeap h = new QHeap();
        int size = sc.nextInt();
        h.heap = new long[size];
        h.heapSize = 0;
        
        while(size-- > 0){
            int type = sc.nextInt();
            if (type == 1){
		//System.out.println("SB Here");
                long valToInsert = sc.nextLong();
                h.heap = h.insert(h.heap, valToInsert, ++h.heapSize);
            } else if (type == 2){
		//System.out.println("Shouldnt b Here");
                long valToDelete = sc.nextLong();
                h.heapSize = h.delete(h.heap, valToDelete, h.heapSize, 0);
            } else if (type == 3) {
		//System.out.println("Here");
                if (h.heapSize != 0){
		    for (int i = h.heapSize/2 - 1; i >= 0; i--)
                    {
                          h.minHeapify(h.heap, i, h.heapSize);
        	    }
                    System.out.println(h.heap[0]);
		}
            }
        }
        
    }
    
	public int delete(long[] heap, long val, int heapSize, int i){
            if (heap[i] == val){
                if (i == heapSize - 1){
                    // if val is at the very end, then we just discard the value.
                    return --heapSize;
                } else {
                    // swap data with last val
		    if (heap[i] != heap[heapSize - 1]){
	        	heap = swap(i, heapSize - 1, heap);
                    }
                    // discard last val
                    heapSize--;
                    
                    //min heapify the resulting set   
                    minHeapify(heap, i, heapSize);
                    return heapSize;
                }
            } else {
		int leftChild = leftChild(heap,i,heapSize);
		int rightChild = rightChild(heap,i,heapSize);
		if (leftChild != -1 && heap[leftChild] >= val){
			delete(heap, val, heapSize, leftChild);
		}
		if (rightChild != -1 && heap[rightChild] >= val){
			delete(heap, val, heapSize, rightChild);
		}
	    }
        // if its hear then the val was not found in the heap
        return heapSize;
    }
  	 
    public int findInHeap(long[] heap, long val, int heapSize) {
	return findInHeapStartingFrom(heap, val, heapSize, 1);		
    }

    private static int findInHeapStartingFrom(long[] heap, long key, int last, int pos) {
	    if (last <= pos) {
	      return -1;
	    }
	    if (heap[pos] == key) {
	      return pos;
	    }
	    int foundInLeft = findInHeapStartingFrom(heap, key, last, pos*2 + 1);
	    if (foundInLeft > -1) {
	      return foundInLeft;
	    }
	    return findInHeapStartingFrom(heap, key, last, pos*2+2);
    }

    public long[] insert(long[] heap, long val,int heapSize){
        heap[heapSize - 1] = val;
        // Swap last with first
	/*if(heapSize != 0 && heap[0] != heap[heapSize - 1]){
		//System.out.println("Swap first "+heap[0]+" with last "+heap[heapSize - 1]);
        	heap = swap(0, heapSize - 1, heap);
	}*/
	/*for (int i = heapSize/2 - 1; i >= 0; i--)
        {
             minHeapify(heap, i, heapSize);
        }*/

	//System.out.println("Now min is "+heap[0]);
	return heap;
    }
    
    public long[] minHeapify(long[] heap, int i, int heapSize){
	if (i < heapSize/2){
        	int currIndex = i;
        	int leftChild = leftChild(heap, i, heapSize);
        	int rightChild = rightChild(heap, i, heapSize);
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
    
    public int leftChild(long[] heap, int parent, int heapSize){
        int childIndex = 2*parent + 1;
        if (childIndex < heapSize)
            return childIndex;
        else
            return -1;
    }
    
    public int rightChild(long[] heap, int parent, int heapSize){
        int childIndex = 2*parent + 2;
        if (childIndex < heapSize)
            return childIndex;
        else
            return -1;
    }

    public long[] swap(int i, int j, long[] heap){
	long temp = heap[i];
	heap[i] = heap[j];
	heap[j] = temp;
	return heap;

    }
}
