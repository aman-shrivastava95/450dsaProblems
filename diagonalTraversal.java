

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

class Node
{
    int data; //node data
    Node left, right; //left and right child's reference

    // Tree node constructor
    public Node(int data)
    {
        this.data = data;
         left = right = null;
    }
}

class Tree
{   
    //we will use the simpler method first of using the right , side child only
      public ArrayList<Integer> diagonal(Node root)
      {
           ArrayList<Integer> result = new ArrayList<>() ;
           Queue<Node> q = new LinkedList<>() ;
           q.add(root) ;
           while(!q.isEmpty()){
               //take the current node
               Node temp = q.remove() ;
               //keep moving to its right and keep on processing it
               while(temp!=null){
                   //process it
                   result.add(temp.data) ;
                   if(temp.left!=null) q.add(temp.left) ;
                   temp = temp.right ;
               }
           }
           return result ;
      }
      private void diagonalUtil(Node node, int slope , Map<Integer, ArrayList<Integer>> map){
          if( node == null)
            return ;
         //porcess the current node,ie, put it in the map
         if(map.containsKey(slope)){
             map.get(slope).add(node.data) ;
         }else{
             map.put(slope, new ArrayList<Integer>(Arrays.asList(node.data))) ;
         }
         //when left slope will increase by 1
         diagonalUtil(node.left,slope+1, map) ;
         //when right slope will remain same
         diagonalUtil(node.right,slope, map) ;
      }
      
      //lets try with the recursive method using maps
      public ArrayList<Integer> diagonalPrint(Node root){
          ArrayList<Integer> result = new ArrayList<>() ;
          Map<Integer, ArrayList<Integer>> map = new TreeMap<>() ;
          //slope of root is 0, and everything right will have the same slope, everything left withh have sloper incremented by 1
          diagonalUtil(root, 0,map) ;
          //after the map is filled add them to result
          for(Entry<Integer,ArrayList<Integer>> e:map.entrySet()){
            for(Integer item:e.getValue()){
                result.add(item) ;
            }
          }
          return result ;  
      }
}