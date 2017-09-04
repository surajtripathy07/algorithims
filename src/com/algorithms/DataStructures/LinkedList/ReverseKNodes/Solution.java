import java.util.*;

class Solution{

	private static class Node{
		public Node nxt;
		public int val;

		Node(int val){
			this.val = val;
		}
	}


	public Node reverseK(int k, Node head){
		Node s = head;
		Node e = null;
		Node bS = null;
		Node iter = head;
		int i = 0;
		boolean skip = false;
		while(iter != null){
			i++;
			if (i % k == 0){
				if (!skip){
					e = iter;
					Node n = e.nxt;
					reverse(s, e);
					s.nxt = n;
					if (bS != null){
						bS.nxt = e;
					}
					iter = s;
					if (i == k){
						head = e;
					}
				} else {
					bS = iter;
					s = iter.nxt;
				}	

				skip = !skip;
			}

			iter = iter.nxt;
		}	
		return head;
	}

	public Node reverse(Node s, Node e){
		if (s == e){
			return e;
		}
		Node n = reverse(s.nxt, e);
		n.nxt = s;
		return s;
	}

	public Node insert(Node head, int val){
		if (head == null){
			return new Node(val);
		} else {
			head.nxt = insert(head.nxt, val);
		}
		return head;
	}

	public void display(Node h){
		while(h != null){
			System.out.println(h.val);
			h = h.nxt;
		}
	}

	public static void main(String[] args){
		Solution s = new Solution();
		Node head = s.insert(null, 10);
		s.insert(head, 11);
		s.insert(head, 12);
		s.insert(head, 13);
		s.insert(head, 14);
		s.insert(head, 15);
		s.insert(head, 16);
		s.insert(head, 17);
		s.insert(head, 18);
		s.insert(head, 19);
		s.display(head);
		System.out.println("==================================");
		Node nHead = s.reverseK(5, head);
		s.display(nHead);
	}

}
