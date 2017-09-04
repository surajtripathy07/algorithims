import java.util.*;

class Solution{

static class Node 
{
    int data;
    Node left, right;
  
    Node(int item) 
    {
        data = item;
        left = right = null;
    }
}

	public void boundaryTraversal(Node n, String id, int level){
		String leftId = null;
		String rightId = null;
		if (n == null) return;
		if (id.equals("l")){
			System.out.print(" " +n.data+" ");
			leftId = "l";
			if (level > 0){
				rightId = "i";
			} else {
				rightId = "r";
			}
		} else if (id.equals("i")){
			leftId = "i";
			rightId = "i";
			if (n.left == null && n.right == null){
				System.out.print(" " +n.data+" ");
			}
		} else if (id.equals("r")){
			leftId = "i";
			rightId = "r";
		}

		boundaryTraversal(n.left, leftId, level + 1);
		boundaryTraversal(n.right, rightId, level + 1);
		if (id.equals("r")){
			System.out.print(" " +n.data+" ");
		}
	}


	public static void main(String[] args){

		Solution s = new Solution();
		/*Node root = new Node(20);
        	root.left = new Node(8);
        	root.left.left = new Node(4);
        	root.left.right = new Node(12);
        	root.left.right.left = new Node(10);
        	root.left.right.right = new Node(14);
        	root.right = new Node(22);
		root.right.right = new Node(25);
		
		Node root = new Node(20);
		root.left = new Node(8);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		root.right = new Node(22);
		root.right.right = new Node(25);
		*/
	        Node root = new Node(20);
		root.left = new Node(8);
		root.left.right = new Node(12);
		root.left.right.left =new  Node(10);
		root.left.right.left.left = new  Node(16);
		root.left.right.right = new Node(14);
		root.right = new Node(22);
		root.right.right = new Node(25);
		s.boundaryTraversal(root, "l", 0);
		System.out.println();
		
	}

}
