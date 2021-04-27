import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class priorityQueueExample{
    public static void main(String[] args) {
        //it will follow the heap structure internally 
        //normal pq with natural ordering
        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.asList( 1, 3, 5, 4, 6, 13, 10,9, 8, 15, 17 )) ;
        //priroty queue with comparator as lambda
        PriorityQueue<Integer> p = new PriorityQueue<>((x,y)->Integer.compare(y, x)) ;
        PriorityQueue<Integer> pe = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 -o1 ;
            }
            
        }) ;
        pq.clear(); 
        pq.add(88) ;
        pq.add(3) ;
        pq.add(5) ;
        pq.add(4) ;
        pq.add(6) ;
        pq.add(13) ;
        pq.add(10) ;
        pq.add(9) ;
        pq.add(8) ;
        pq.add(15) ;
        pq.add(17) ;
        pq.add(2) ;
        System.out.println(pq);
        System.out.println(pq.peek());
        pq.clear(); 
        p.add(88) ;
        p.add(3) ;
        p.add(5) ;
        p.add(4) ;
        p.add(6) ;
        p.add(13) ;
        p.add(10) ;
        p.add(9) ;
        p.add(8) ;
        p.add(15) ;
        p.add(17) ;
        p.add(2) ;
        System.out.println(p);
        System.out.println(p.peek());

    }
}