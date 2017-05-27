/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
     Node prev;
  }
*/

Node Reverse(Node head) {
    Node newHead = null;
    if (head == null){
        return null;
    }
    if (head.next != null){
        newHead = Reverse(head.next);
    }
    Node temp = head.next;
    head.next = head.prev;
    head.prev = temp;
    
    if (newHead == null){
        return head;
    } else {
        return newHead;
    }
    
    
}
