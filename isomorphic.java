
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
    // Return True if the given trees are isomotphic. Else return False.
    boolean isIsomorphic(Node root1, Node root2)  
    { 
        if(root1 ==null && root2 == null)
            return true ;
        if(root1 ==null || root2 == null)
            return false ;
        
        if( root1.data !=root2.data)
            return false ;
      
        // at this point the data of the both tree's root are same , that means, there are two cases possible 
        //1-> we do not flip it , so both the left AND right subtree should be isomorphic.
        //OR
        //2-> we flip it, and again, both the left AND right subtree should be isomorphic.
        return (isIsomorphic(root1.left, root2.left) &&
                isIsomorphic(root1.right, root2.right) ||
                isIsomorphic(root1.left, root2.right) &&
                isIsomorphic(root1.right, root2.left) ) ;
         
    }
    
}    