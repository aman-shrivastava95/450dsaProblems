class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
}

class Tree
{
    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
    {
        if(root == null) return true ;
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(height(root.left)-height(root.right)) <=1) ;
    }
    //helper function to calculate the height of the subtree
    int height(Node root){
        if( root == null )
        return 0 ;
        return Math.max(height(root.left), height(root.right)) + 1 ;
    }
}