

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
class Tree

{
    //This can be done using the level order, the first element of every level order will be the left most we need.
    //we can use recursion as well as the queue method to do this
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> leftView = new ArrayList<>() ;
      if( root == null)
        return leftView ;
      Queue<Node> q = new LinkedList<>() ;
    //add first elemenet to the linked list
    q.add(root) ;
    while(!q.isEmpty()){
        
    //remove all the node from the curreent level and keep on adding their child to form the next level, and when its first , add them to answer
        int n = q.size() ;
        for(int i = 0;i< n;i++){
            Node temp = q.poll() ;
            if(temp.left!=null)
                q.add(temp.left) ;
            if(temp.right!=null)
                q.add(temp.right) ;
            if(i == 0)//for right view just change it to the lat element at current level
                leftView.add(temp.data) ;
        }
        
    }
      return leftView ;
    }
}