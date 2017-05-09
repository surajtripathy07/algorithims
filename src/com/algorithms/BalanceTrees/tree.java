import java.util.*;
class tree{

	static class Node{
		public Node left;
		public Node right;
		public int val;
		int ht;
		Node(int val){
			this.val = val;
		}
		Node(){
		}
	}

   static Node insert(Node node,int key){
       if (node == null){
           node = new Node();
           node.val = key;
           node.ht = 0;
           return node;
       }
       if(key < node.val){
           node.left = insert(node.left, key);
       } else {
           node.right = insert(node.right, key);
       }
       node.ht = height(node);
       int balance = getbalance(node);
 //      System.out.println("Balance of node "+node.val+" is " + balance );
//	System.out.println("height "+node.ht);
       
       if (balance < -1){
           // Right heavy
           int rightSubBalance = getbalance(node.right);
           
           if (rightSubBalance <= -1){
             // Right Right case
               node = leftRotate(node);
           } else if (rightSubBalance >= 1){
               // Right Left rotation
               node.right = rightRotate(node.right);
               node = leftRotate(node);
           }
       } else if (balance > 1){
           // Left Heavy
           int leftSubBalance = getbalance(node.left);
           
           if (leftSubBalance >= 1){
               // left left case
               node = rightRotate(node);
           } else if (leftSubBalance <= -1){
               // left right case
               node.left = leftRotate(node.left);
               node = rightRotate(node);
           }
       }
       return node;
    }

    static Node leftRotate(Node root){
        Node parent = root;
        Node child = root.right;
        // Rotation
        parent.right = child.left;
        child.left = parent;
        
        parent.ht = height(parent);
        child.ht = height(child);
        return child;
    }
    static Node rightRotate(Node root){
        Node parent = root;
        Node child = root.left;
        // Rotation
        parent.left = child.right;
        child.right = parent;
        
        parent.ht = height(parent);
        child.ht = height(child);
        return child;
    }
    static int getbalance(Node root){
        int l = -1;
        if (root.left != null){
            l = root.left.ht;
        }
        int r = -1;
        if (root.right != null){
            r = root.right.ht;
        }
        
        return l - r;
    }

    static int height(Node root){
        return 1 + max(root.left, root.right);
    }

    static int max(Node left, Node right){
        int leftI = -1;
        if (left != null){
            leftI = left.ht ;
        }
        int rightI = -1;
        if (right != null){
            rightI = right.ht;
        }
        return leftI > rightI ? leftI : rightI;
    }
    
public static void main(String args[]){
	Node root = null;
	Scanner sc = new Scanner(System.in);
	int cont = 0;
	while(cont == 0){
		root = insert(root, sc.nextInt());
		cont = sc.nextInt();
	}
	dispTree(root);
}

public static void dispTree(Node root){
	
	System.out.print("["+root.val+"]("+root.ht+") ");
	if (root.left != null){
		dispTree(root.left);
	}

	if (root.right != null){
		dispTree(root.right);
	}
}


}
