   /* Class node is defined as :
    class Node 
       int val;   //Value
       int ht;      //Height
       Node left;   //Left child
       Node right;   //Right child

   */

   static Node insert(Node root,int val){
        if (root == null){
            root = new Node();
            root.val = val;
            root.ht = 0;
            return root;
        }
       
       if (root.val < val ){
           root.ht += 1;
           if (root.right != null){
            insert(root.right, val);
           } else {
               root.right = new Node();
               root.right.val = val;
               root.right.ht = 0;
           }
       } else {
           root.ht -= 1;
           if (root.left != null){
            insert(root.left, val);
           } else {
               root.left = new Node();
               root.left.val = val;
               root.left.ht = 0;
           }
       }
       balanceAVL(root);
       return root;
       
   }

    static void balanceAVL(Node root, int val){
        if (-1 <= root.ht && root.ht <= 1){
            return;
        }
        // checking if right or left heavy
        if (root.height > 1){
            // right heavy
            if (root.right.height > 0){
                // right - right
                Node r = root;
                Node rr = root.right;
                r.right = rr.left;
                rr.left = r;
                r.height = 0;
                rr.height = 0;
                return rr;
            } else {
                // right - left
               Node r = root;
               Node rh = root.right;
               Node lh = root.left;
               
               rh.left = lh.right;
               lh.right = rh;
               r.right = lh;
               lh.ht = 1;
               rh.ht = 0;
               
               r.right = lh.left;
               lh.left = r;
               r.height = 0;
               lh.height = 0;
                return lh;
            }
        } else {
            //left heavy
            if (root.left.height < 0){
                // left - left
                
                
            } else {
                // left - right
                
                
            }
        }
        
    }

