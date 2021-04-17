

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
    static ArrayList<Integer> answer = new ArrayList<>() ;
    //Function to return the level order traversal of a tree.(method using queue)
    static ArrayList<Integer> levelOrder(Node node) 
    {
        Queue<Node> q = new LinkedList<>() ;
        ArrayList<Integer> result = new ArrayList<>() ;
        //push the first node in the queue
        q.add(node) ;
        while(!q.isEmpty()){
            //pop the first node and process it
            Node curr = q.remove() ;
            result.add(curr.data) ;
            //push all the children to the queue
            if(curr.left!=null)q.add(curr.left) ;
            if(curr.right!=null)q.add(curr.right) ;
        }
        return result ;

    }
    static ArrayList<Integer> reverseLevelOrder(Node node) 
    {
    
        ArrayList<Integer> result = new ArrayList<>() ;
        Queue<Node> q = new LinkedList<>() ;
        Stack<Node> s = new Stack<>() ;
        q.add(node) ;
        while(!q.isEmpty()){
            Node curr = q.remove() ;
            s.push(curr) ;
            //add first the right child and then the left child
            if(curr.right!=null)q.add(curr.right) ;
            if(curr.left!=null)q.add(curr.left) ;
        }
        //after this is done just reomve everything from the stack
        while(!s.empty()){
            result.add(s.pop().data) ;
        }
       
        return result ;

    }

    //recursive method this will print node at given level, we need to call this method by first calculating the 
    //height and then passing it to this method.
    static void levelOrderHelper(Node node, int level){
        if(node == null)
            return  ;
        if( level == 1)
            answer.add(node.data) ;
        //go to subsequesnt level
        levelOrderHelper(node.left, level-1) ;
        levelOrderHelper(node.right, level-1) ;
    }
    
}
