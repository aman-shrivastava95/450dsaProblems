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
    //Function to return the lowest common ancestor in a Binary Tree.
	Node lca(Node root, int n1,int n2)
	{   
        //base cases
        if(root == null)
            return null ;
        if(root.data==n1 || root.data ==n2)
            return root ;
            
        //for a given root find if we can get n1 or n2, in its subtree.
        Node leftFind = lca(root.left, n1,n2) ;
        Node rightFind = lca(root.right,n1,n2) ;
        //if it finds both from the left and right it will return itself as, we are going down in the recursion and this is the first time
        //it returns both
        if(leftFind!=null && rightFind!=null)
            return root;
        if(leftFind!=null)
            return leftFind ;
        else    
            return rightFind ;
	}
}