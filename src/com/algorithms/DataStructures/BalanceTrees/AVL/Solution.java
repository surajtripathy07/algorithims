import java.util.*;

class Solution
{

	private static class Node {
		public int key;
		public Node left;
		public Node right;
		public int ht;
		public Node p = null;
		
		Node(int key){
			this.key = key;
			left = null;
			right = null;
			ht = 0;
		}

	}
	
	public void inOrder(Node root){
		if (root == null) return;
		inOrder(root.left);
		System.out.println(root.key);
		inOrder(root.right);
	}

	public void printTree(ArrayList<Node> level){
		if (level == null || level.isEmpty()){
			return;
		}
	
		ArrayList<Node> nL = new ArrayList<Node>();
		StringBuilder b = new StringBuilder();
		for (Node n : level){
			if (n.left != null){
				n.left.p = n;
				nL.add(n.left);
			}
			if (n.right != null){
				n.right.p = n;
				nL.add(n.right);
			}
			b.append(n.key).append("(").append(n.p.key).append(")").append("\t");
		}
		System.out.println(b.toString());
		printTree(nL);
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
		root.ht = getHeight(root);
		int bfRoot = getBF(root);
		if (bfRoot > 1){
			// Right Heavy
			int rightBf = getBF(root.right);
			if ( rightBf <= -1){
				// Right-Left Case
				root.right = rightRotate(root.right.left, root.right);
			}
			// Right-Right Case
			root = leftRotate(root.right, root);
		} else if (bfRoot < -1){
			// Left Heavy
                        int leftBf = getBF(root.left);
                        if ( leftBf >= 1){
                                // Left-Right Case
                                root.left = leftRotate(root.left.right, root.left);
                        }
                        // Left-Left Case
                        root = rightRotate(root.left, root);
		}

		return root;
		
	}
	
	public int getHeight(Node n){
		return 1 + Math.max(getNodeHeight(n.left), getNodeHeight(n.right));
	}

	public int getNodeHeight(Node n){
		if (n == null) return 0;
		else return n.ht;
	}

	public int getBF(Node n){
		int l = -1;
		int r = -1;
		if (n.left != null){
			l = n.left.ht;
		} 
		if (n.right != null){
			r = n.right.ht;
		}
		return r - l;
	}

	public Node leftRotate(Node toRotate, Node parent){
		parent.right = toRotate.left;
		toRotate.left = parent;
		int temp = toRotate.ht;
		toRotate.ht = parent.ht;
		parent.ht = temp;
		return toRotate;
	}

	public Node rightRotate(Node toRotate, Node parent){
		parent.left = toRotate.right;
		toRotate.right = parent;
		int temp = toRotate.ht;
        toRotate.ht = parent.ht;
        parent.ht = temp;
        return toRotate;
	}

	public static void main(String args[]){
		Solution s = new Solution();
		ArrayList<Node> lst = new ArrayList<Node>();
		Node r = null;
		r = s.insert(r, 1);
		System.out.println("Root now is "+r.key+" bf is "+s.getBF(r)+" height is "+r.ht);
		s.pT(r, lst);
		
		r = s.insert(r, 2);
		System.out.println("Root now is "+r.key+" bf is "+s.getBF(r)+" height is "+r.ht);
		s.pT(r, lst);
		
		r = s.insert(r, 3);
		System.out.println("Root now is "+r.key+" bf is "+s.getBF(r)+" height is "+r.ht);
		s.pT(r, lst);
		
		r = s.insert(r, 4);
		System.out.println("Root now is "+r.key+" bf is "+s.getBF(r)+" height is "+r.ht);
		s.pT(r, lst);
		
		r = s.insert(r, 5);
		System.out.println("Root now is "+r.key+" bf is "+s.getBF(r)+" height is "+r.ht);
		s.pT(r, lst);
		
		r = s.insert(r, 6);
		System.out.println("Root now is "+r.key+" bf is "+s.getBF(r)+" height is "+r.ht);
		s.pT(r, lst);
		
		r = s.insert(r, 7);
		System.out.println("Root now is "+r.key+" bf is "+s.getBF(r)+" height is "+r.ht);
		s.pT(r, lst);
		
		r = s.insert(r, 8);
		System.out.println("Root now is "+r.key+" bf is "+s.getBF(r)+" height is "+r.ht);

		//s.inOrder(r);	
		s.pT(r, lst);
	}

	public void pT(Node r, ArrayList<Node> lst){
		lst.clear();
		r.p = new Node(-1);
        	lst.add(r);
        	printTree(lst);
	}

}
