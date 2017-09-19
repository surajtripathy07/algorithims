import java.util.*;

class HeapNode {

	public Character ch;
	public int freq;
	public HeapNode left;
	public HeapNode right;

	HeapNode(int frequency, char ch) {
		this.freq = frequency;
		this.ch = (Character) ch;
	}
}

class MinHeap {

	public int size;
	public HeapNode[] heap;
	public int capacity;

	MinHeap(int n) {
		this.heap = new HeapNode[n];
		this.capacity = n;
	}
}

class Solution {

	public void minHeapify(MinHeap h, int pos) {
		int left = 2 * pos + 1;
		int right = 2 * pos + 2;
		int prev = pos;
		if (left < h.size && h.heap[left].freq < h.heap[prev].freq) {
			prev = left;
		}

		if (right < h.size && h.heap[right].freq < h.heap[prev].freq) {
			prev = right;
		}

		if (prev != pos) {
			// swap prev and pos
			HeapNode temp = h.heap[prev];
			h.heap[prev] = h.heap[pos];
			h.heap[pos] = temp;

			minHeapify(h, prev);
		}
	}

	public MinHeap buildMinHeap(char[] arr, int[] freq) {
		MinHeap mH = new MinHeap(arr.length);
		for (int i = 0; i < arr.length; i++) {
			mH.heap[i] = new HeapNode(freq[i], arr[i]);
		}
		mH.size = mH.heap.length - 1;
		for (int i = (arr.length - 1) / 2; i >= 0; i--) {
			minHeapify(mH, i);
		}
		return mH;
	}

	public HeapNode extractMin(MinHeap mH) {
		HeapNode min = mH.heap[0];
		HeapNode last = mH.heap[mH.size];
		mH.heap[mH.size] = min;
		mH.heap[0] = last;
		mH.size--;
		minHeapify(mH, 0);
		return min;
	}

	public int parent(int i) {
		return (i - 1) / 2;
	}

	public void insert(MinHeap mH, HeapNode h) {
		if (mH.size == mH.capacity)
			return;
		mH.size++;
		mH.heap[mH.size] = h;
		int i = mH.size;
		while (i != 0 && mH.heap[parent(i)].freq > mH.heap[i].freq) {
			int p = parent(i);
			HeapNode t = mH.heap[i];
			mH.heap[i] = mH.heap[p];
			mH.heap[p] = t;
			i = p;
		}
	}

	public HeapNode buildHuffManTree(char[] arr, int[] freq) {
		HeapNode left = null;
		HeapNode right = null;
		HeapNode top = null;
		MinHeap mH = buildMinHeap(arr, freq);
		while (mH.size > 0) {
			left = extractMin(mH);
			right = extractMin(mH);
			System.out.println(left.freq + right.freq);
			top = new HeapNode(left.freq + right.freq, '$');
			top.left = left;
			top.right = right;
			insert(mH, top);
		}
		return extractMin(mH);
	}

	public void printHuffManCode(HeapNode h, StringBuilder b) {
		if (h == null)
			return;
		if (h.left == null && h.right == null)
			System.out.println(h.ch + " " + b.toString());
		else {
			printHuffManCode(h.left, b.append(0));
			b.setLength(b.length() - 1);
			printHuffManCode(h.right, b.append(1));
			b.setLength(b.length() - 1);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		char arr[] = {'a', 'b', 'c', 'd', 'e', 'f'};
		int freq[] = {5, 9, 12, 13, 16, 45};
		HeapNode h = s.buildHuffManTree(arr, freq);
		s.printHuffManCode(h, new StringBuilder());
	}

}

