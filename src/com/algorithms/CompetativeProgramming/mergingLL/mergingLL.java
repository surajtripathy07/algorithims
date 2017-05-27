/*
  Find merge point of two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
int FindMergeNode(Node headA, Node headB) {
    // Complete this function
    // Do not write the main method. 
   if (headA == null || headB == null){
       return 0;
   }
   /* O(N*M)
    while(headA != null){
        Node temp = headB;
        while(headB != null){
            //System.out.println("Comparing "+ headA.data + " and "+headB.data);
            if (headA == headB){
                return headA.data;
            }
            headB = headB.next;
        }
        headB = temp;
        //System.out.println("Changed head from "+headA.data+" to head next "+ headA.next.data );
        headA = headA.next;
        
    }*/
    
    //O(N)
    int lenList1 = 0;
    for (;headA != null; headA = headA.next){
        lenList1++;
        System.out.print(headA.data+ " ");
    }
    System.out.println();
    int lenList2 = 0;
    for (;headB.next != null; headB = headB.next){
        System.out.print(headB.data+ " ");
        lenList2++;
    }
    
    System.out.println("len1 "+lenList1 + " len2 "+lenList2);
    while(lenList1 > lenList2){
        lenList1--;
        headA = headA.next;
    }
    
    while(lenList2 > lenList1){
        lenList2--;
        headB = headB.next;
    }
    
    while(headA != null){
        if (headA == headB){
            return headA.data;
        }
        headA = headA.next;
        headB = headB.next;
    }
    
    
    return 0;
}

