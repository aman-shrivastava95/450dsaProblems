

import java.util.Stack;

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
    static void preOrderIterative(Node root){
        //we will be using the stack to print the inorder iterative version
        Stack<Node> s  = new Stack<>() ;
        Node curr = root ;
        s.push(curr) ;
        while(!s.empty()){
            //process the node which is in the stack
            curr = s.pop() ;
            System.out.println(curr.data);
            //right node should be pushed first as it will be processed later
            if(curr.right!=null)s.push(curr.right) ;
            if(curr.left!=null)s.push(curr.left) ;
        }
    }
}