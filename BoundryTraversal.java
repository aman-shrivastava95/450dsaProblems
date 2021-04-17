

import java.util.ArrayList;

class Node 
 { 
    int data; 
    Node left, right; 
   
    public Node(final int d) {
        data = d;
        left = right = null;
    }
}

class Solution {

     void rightBoundary(Node node, ArrayList<Integer> result) {
        if( node == null)
        return ;
    if(node.right!=null){
        rightBoundary(node.right, result);
        result.add(node.data) ;
    }
    else if(node.left!=null){
        rightBoundary(node.left, result);
        result.add(node.data) ;
    }
	}

	 void leaves( Node node, ArrayList<Integer> result) {
        if( node == null)
            return ;
        
        //the order here is important , since we need to print the leaves in the order left to right.
        leaves(node.left, result);
        if(node.left == null && node.right == null){
            result.add(node.data) ;
        }
        leaves(node.right, result);
    }

     void leftBoundary( Node node,  ArrayList<Integer> result) {
        if( node == null)
            return ;
        if(node.left!=null){
            result.add(node.data) ;
            leftBoundary(node.left, result);
        }
        else if(node.right!=null){
            result.add(node.data) ;
            leftBoundary(node.right, result);
        }

    }
    // the idea is to print the left nodes first, and then the leaves and then all
    // the right node
    ArrayList<Integer> printBoundary(final Node node) {
        final ArrayList<Integer> result = new ArrayList<>();
        result.add(node.data);
        leftBoundary(node.left, result);
        leaves(node.left, result);
        leaves(node.right, result);
        rightBoundary(node.right, result);

        return result;
    }

}