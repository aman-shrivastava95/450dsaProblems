import java.util.ArrayList;

//class representing the node of an n ary tree
class Node{
     int data ;
     ArrayList<Node> children ;
     public Node(int data){
         this.data = data ;
     }
 }

 class Solution{
     Boolean isMirror(Node t1, Node t2){
        
        //data should be same
        if(t1.data !=t2.data)
            return false ;
        //size of children should be same
        if(t1.children.size()!=t2.children.size())
            return false ;

        //at this point both the conditions are met, there sizes are same, then we just have to check for the subtrees ;
        boolean isMirror = true ;
        for(int i = 0 ;i< t1.children.size();i++){
            isMirror = isMirror && isMirror(t1.children.get(i),t2.children.get(t2.children.size() -i -1)) ;
        }
        return isMirror ;
        
     }
 }