import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;


class Node{
    int data ;
    Node left, right ;
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null ;
	}
}


class Solution
{
    // function should print the topView of the binary tree using queue here
    static ArrayList<Integer> topView(Node root)
    {
        class Pair<S,T>{
            S first ;
            T Second ;
            public Pair(S first, T Second){
                this.first = first ;
                this.Second = Second ;
            }
        }
       
        ArrayList<Integer> result = new ArrayList<>() ;
        //we will also need a map here to store all the top values from the vertical order traversals
        Map<Integer,Node> map  =  new TreeMap<>() ;
        if( root == null) return result ;
        // push Pair formed by root and its horizontal distanc ein the queue, root will have distance of 0 ;
        Pair<Node, Integer> p = new Pair<>(root, 0) ;
        Queue<Pair<Node, Integer>> q  =  new LinkedList<>() ;
        q.add(p)  ;
        while(!q.isEmpty()){
            Pair<Node,Integer> temp = q.poll() ;
            if(!map.containsKey(temp.Second))
                map.put(temp.Second, temp.first) ;
            if(temp.first.left!=null)
                q.add(new Pair<Node, Integer>(temp.first.left,temp.Second -1)) ;
            if(temp.first.right!=null)
                q.add(new Pair<Node, Integer>(temp.first.right,temp.Second +1)) ;
        }
        //map is ready , now fill this into the arraylist
        for(Entry<Integer,Node> e:map.entrySet()){
            result.add(e.getValue().data) ;
        }
        return result ;
        
    }
}