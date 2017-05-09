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

Node SortedInsert(Node head,int data) {
  if (head == null){
      head = new Node();
      head.data = data;
  }
    Node front = new Node();
    front.data = Integer.MIN_VALUE;
    front.next = head;
    while(front.data < data && front.next != null){
        front = front.next;
    }
    Node add = new Node();
    add.data = data;
    if (front.data > data){
        // add before front
        if (front == head){
            head = add;
        }
        add.prev = front.prev;
        add.next = front;
        add.prev.next = add;
        front.prev = add;
    }
    else{
        // after front
        //front is last or somewhere in middle
        add.next = front.next;
        add.prev = front;
        if (front.next != null){
            front.next.prev = add;
        }
        front.next = add;
    }
    return head;  
}

