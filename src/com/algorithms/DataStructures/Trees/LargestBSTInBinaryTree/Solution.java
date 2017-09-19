import java.util.*;

class Solution{


	static class Node{
		Node left;
		Node right;
		int data;
		metadata subtreeData;
		Node(int data){
			this.left = null;
			this.right = null;
			this.data = data;
		}
	}

	static class metadata{
		int max;
		int min;
		int size;
		boolean isBST;
		
		metadata(int max, int min, int size, boolean isBST){
			this.max = max;
			this.min = min;
			this.size = size;
			this.isBST = isBST;
		}

	}

	public metadata longestBST(Node n){
		if (n == null) return new metadata(Integer.MIN_VALUE, Integer.MAX_VALUE, 0,true);

		metadata leftSt = longestBST(n.left);
		metadata rightSt = longestBST(n.right);
		boolean isBST = true;
		int size = 1;
		int min = n.data;
		int max = n.data;

		if (!leftSt.isBST || !rightSt.isBST || leftSt.max > n.data || rightSt.min <= n.data){
			size = Math.max(leftSt.size, rightSt.size);
			n.subtreeData = new metadata(0, 0, size, false);
		} else {
			size = leftSt.size + rightSt.size + 1;
			min = n.left != null ? leftSt.min : n.data;
			max = n.right != null ? rightSt.max : n.data;
			n.subtreeData = new metadata(max,min, size, isBST);
		}	
	
		return n.subtreeData;
	} 

	public int getLongestBST(Node root){
		metadata r = longestBST(root);
		return r.size;
	}

	public static void main(String args[]){
		Solution s = new Solution();
		Node root = new Node(50);
        	root.left = new Node(10);
        	root.right = new Node(60);
        	root.left.left = new Node(5);
        	root.left.right = new Node(20);
        	root.right.left = new Node(55);
        	root.right.left.left = new Node(45);
        	root.right.right = new Node(70);
        	root.right.right.left = new Node(65);
        	root.right.right.right = new Node(80);
		System.out.println(s.getLongestBST(root));
				
	
	}

}
