/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {

    if (head == null){
        return false;
    }
    Node hare = head;
    Node tortoise = head;
    
    while(hare.next != null){
        hare = hare.next;
        if (hare == tortoise){
            return true;
        } else {
            hare = hare.next;
            if (hare == null){
                return false;
            }
            if (hare == tortoise){
                return true;
            }
        }
        tortoise = tortoise.next;
    }
    
    return false;
    
}

