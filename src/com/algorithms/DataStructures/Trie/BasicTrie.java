import java.util.*;
import java.lang.*;

class Node{
public Node[] children;
public String key;
public boolean isLeaf;
public int size;
	Node(boolean isLeaf, String key, Character[] children) {
		this.isLeaf = isLeaf;
		this.key = key;
		this.children = children;
		size = 0;
	}
}

public class BasicTrie{
	public static void main(String args[]) {
		BasicTrie b = new BasicTrie();
		Scanner sc = new Scanner(System.in);
		Node root = new Node(false, "", new Character[27]);
	}

	public Node insert(String key, Node root, int start){
		if (root != null && root.children != null){
			int index = getIndex(key.charAt(i));
			if (children[index] != null){
				if (children[index].isLeaf){
					String nkey = children[index].key;
					children[index].key = null;
					children[index].isLeaf = false;
					// Move existing Key to a lower node	
					insert(nkey, children[index], i+1);
				 	insert(key, children[index], i+1);
					// assuming duplicates are not getting inserted
					root.size++;
				}					
			} else {
				children[index] = new Node(true, key, null);
				root.size++;
				break;
			}
		}
		return root;
	}

	public int getIndex(Character c){
		int start = (int)'a';
		return ((int)c - start);
	}

}
