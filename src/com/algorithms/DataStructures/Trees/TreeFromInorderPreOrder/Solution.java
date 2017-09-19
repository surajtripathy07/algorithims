import java.util.*;

class Solution {

	static class Node{
		public Node left;
		public Node right;
		public Character data;
		Node(Character c){
			this.data = c;
		}
	}

	int index = 0;

	public Node buildTree(Character[] inOrder, Character[] preorder, int start, int end){
		if (start > end) return null;
		Character root = preorder[index];
		int inIndex = searchRoot(inOrder, root);
		if (inIndex == -1) return null;
		index++;
		Node r = new Node(inOrder[inIndex]);
		r.left = buildTree(inOrder, preorder, start, inIndex - 1);
		r.right = buildTree(inOrder, preorder, inIndex + 1, end);
		
		return r;	
	}

	public int searchRoot(Character[] arr, Character toSearch){
		for (int i = 0; i < arr.length; i++){
			if (arr[i].equals(toSearch))
				return i;
		}

		return -1;
	}

	public void inorder(Node r){
		if (r == null) return ;
		inorder(r.left);
		System.out.println(r.data);
		inorder(r.right);
	}

	public static void main(String args[]){
		Solution s = new Solution();
		Character[] in = {'d', 'b', 'e', 'a', 'f', 'c'};

		Character[] pre = {'a', 'b', 'd', 'e', 'c', 'f'};

		Node h = s.buildTree(in, pre, 0, in.length - 1);
		
		s.inorder(h);
	}

}
