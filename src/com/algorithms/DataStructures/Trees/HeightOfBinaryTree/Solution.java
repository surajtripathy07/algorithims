	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	static int height(Node root) {
        
        if (root == null){
            return -1;
        }
        return height(root, 0, 0);
        /*
        // found tree height using BFS
      	ArrayList<Node> currLevel = new ArrayList<Node>();
        currLevel.add(root);
        int level = 0;
        
        while(!currLevel.isEmpty()){
            ArrayList<Node> fill = new ArrayList<Node>();
            Iterator<Node> iter = currLevel.iterator();
            while(iter.hasNext()){
                Node n = iter.next();
                iter.remove();
                if (n.left != null)
                    fill.add(n.left);
                if (n.right != null)
                    fill.add(n.right);
            }
            if (!fill.isEmpty()){
                level++;
            }
            currLevel = fill;
        }
        return level;
        */
    }

    static int height(Node node, int height, int max){
        if (node.left != null){
            max = height(node.left, height + 1, max);
        }
        // after reaching left max
        if (max < height){
            max = height;
        }
        if (node.right != null){
            max = height(node.right, height + 1, max);
        }
        return max;
    }

