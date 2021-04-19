class Node{
    int data;
    Node left,right;
    Node(int d){
    	data=d;
    	left=null;
    	right=null;
    }
}

class Solution{
    //this will convert the tree also and return the value of the final root node
    public int toSumTree(Node root){
        if( root==null)
            return 0 ;
      //store the old value
        int oldValue = root.data ;
        root.data = toSumTree(root.left) + toSumTree(root.right);

        return root.data + oldValue ;
    }
   
}