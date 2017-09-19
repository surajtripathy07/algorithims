import java.util.*;

class Solution {

	static class Node{
		Node left;
		Node right;
		int data;
		Node(int data){
			this.data = data;
		}
	}

	Node getLCA(int n1, int n2, Node n){
		if (n == null) return n;

		if (n1 > n.data && n2 > n.data)
			return getLCA(n1, n2, n.right);
		else if (n1 < n.data && n2 < n.data)
			return getLCA(n1, n2, n.left);
		return n;
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

		Node lca = s.getLCA(20, 3, root);
		System.out.println(lca.data);
			
	}

}
