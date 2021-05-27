import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Node{
    int data ;
    Node left,  right ;
}

public class HavingFun{
    public static void main(String[] args) {
        
        //priority queue with lambdas in place ofcomparator
        //in lambdas we don't need to provide the type as we do in comparators, here just pass the objects, in lamdas parameter\
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(( o1, o2)->{return o1.compareTo(o2);}) ;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(( o1, o2)->{return -1*o1.compareTo(o2);}) ;//reverse the natural ordering.
        
        //having fun with arraylist
        ArrayList<Integer> l = new ArrayList<>() ;
        ArrayList<Node> nl = new ArrayList<>() ;
      

        //use compareTo in strings comparison /non-primitive comparisons and subtraction trick in primitives.
        //how to sort the collections
        Collections.sort(l,(o1,o2)->{return o1.compareTo(o2);});
        Collections.sort(nl,(n1,n2)->{return n1.data-n2.data;}) ;

    }
}