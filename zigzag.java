import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//class to represent a node
class Node{
    int data ;
    Node left, right ;
    public Node(int data){
        this.data  = data ;
        this.left = this.right = null ;
    }
}
class Solution{
    
    //this is the iterative version using the queue , this can be done recursively as well.
    static ArrayList<Integer> zigzag(Node root){
        ArrayList<Integer> result = new ArrayList<>() ;
        Queue<Node> q = new LinkedList<>() ;
        int level  = 0 ;
        q.add(root) ;
        while(!q.isEmpty()){
            int n = q.size() ;
             if(level%2==0){
                for (int i = 0; i < n; i++) {
                    Node temp = q.remove() ;
                    result.add(temp.data) ;
                    if(temp.left!=null) q.add(temp.left) ;
                    if(temp.right!=null) q.add(temp.right) ;
                }
                level++ ;
             }
             else{
                 Stack<Integer> s = new Stack<>() ;
                 for (int i = 0; i < n; i++) {
                    Node temp = q.remove() ;
                    s.push(temp.data) ;
                    if(temp.left!=null) q.add(temp.left) ;
                    if(temp.right!=null) q.add(temp.right) ;
                }
                while(!s.empty()){
                    result.add(s.pop()) ;
                }
                level++ ;
             }
        }
        return result ;
    }

}
