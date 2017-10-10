import java.util.*;

class Solution{

	static class Node{
		public Node left;
		public Node right;
		public int key;

		Node(int key){
			left = null;
			right = null;
			this.key = key;
		}
	}

	public Node insert(Node root, int key){
		if (root == null){
			return new Node(key);
		}
		if (key > root.key){
			root.right = insert(root.right, key);
		} else {
			root.left = insert(root.left, key);
		}
		return root;
	}
	
	public Node minValue(Node root){
		while (root.left != null){
			root = root.left;
		}
		return root;
	}	

	public Node delete(Node root, int key){
		if (root == null) return root;
		// Delete logic comes inside
		if (root.key == key){
			if (root.left == null){
				return root.right;
			} else if (root.right == null){
				return root.left;
			} else {
				Node nxt = minValue(root.right);
				int nxtKey = nxt.key;
				root.key = nxt.key;
				delete(root.right, nxtKey);	
			}
		}else if (key > root.key){
			root.right = delete(root.right, key);
		} else {
			root.left = delete(root.left, key);
		}

		return root;
	}

}
