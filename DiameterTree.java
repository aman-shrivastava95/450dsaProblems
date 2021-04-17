

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class Solution 
{
    //Function to return the diameter of a Binary Tree.
    int diameter(Node root) {
        if( root == null)
            return  0 ;
        int leftSubreeDiameter = diameter(root.left) ;
        int righSubtreeDiameter = diameter(root.right) ;
        int maxD = Math.max(leftSubreeDiameter, righSubtreeDiameter) ;
        //calulate the path from left to right to root
        int leftHeight = height(root.left) ;
        int rightHeight = height(root.right) ;
    
        return Math.max(leftHeight+rightHeight+1, maxD) ;

    }
    //helper function to calculate the height of the subtree
    int height(Node root){
        if( root == null )
        return 0 ;
        return Math.max(height(root.left), height(root.right)) + 1 ;
    }
}
