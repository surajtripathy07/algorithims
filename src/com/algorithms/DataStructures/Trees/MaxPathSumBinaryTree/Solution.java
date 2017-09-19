import java.util.*;

class Solution{

	public int maxSoFar = 0;
	static class Node{
		public Node left;
		public Node right;
		public int data;
		Node(int data){
			this.data = data;
		}
	}

	public int getMaxPath(Node n){
		if (n == null) return 0;

		int l = getMaxPath(n.left);
		int r = getMaxPath(n.right);
		int maxSingle = Math.max(Math.max(l, r) + n.data, n.data);
		
		int maxBoth = Math.max(maxSingle, l + r + n.data);

		maxSoFar = Math.max(maxBoth, maxSoFar);

		return maxSingle;	
	}


	public static void main(String args[]){
		Solution s = new Solution();
		Node root = new Node(10);
        	root.left = new Node(2);
        	root.right = new Node(10);
        	root.left.left = new Node(20);
        	root.left.right = new Node(1);
        	root.right.right = new Node(-25);
        	root.right.right.left = new Node(3);
        	root.right.right.right = new Node(4);
		System.out.println(s.getMaxPath(root)+" " + s.maxSoFar);
	}

}
