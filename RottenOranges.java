import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges{
    int []dx = new int[]{0,0,-1,1};
    int []dy = new int[]{-1,1,0,0};
    //structure for a node
    class  Node{
        int x ,y ;
        public  Node(int x, int y){
            this.x = x ;
            this.y = y ;
        }
    }
    public int solve(int[][] basket) {
        int r = basket.length ;
        int c =  basket[0].length ;
        
        //put all the initial rotten orranges in the queue
        Queue<Node> q = new LinkedList<>()  ;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(basket[i][j]==2)
                    q.add(new Node(i,j));
            }
        }
        int time = 0 ;
        while(!q.isEmpty()){
            int nodeCount = q.size() ;
            //process current level
            while(nodeCount>0){
                Node curNode = q.poll() ;
                //check in all four direction if any oranges can be rotten and put them in the queue
                for(int i=0;i<4;i++){
                    int newX = curNode.x+dx[i] ;
                    int newY = curNode.y+dy[i] ;
                    if(newX>=0 && newX <r && newY>=0 && newY<c && basket[newX][newY]==1)
                       {
                        q.add(new Node(newX,newY));
                        basket[newX][newY] = 2 ;
                       }
                } 
            }
            time+=1;
        }
        boolean allRotted = true ;
        //check if all rotted or not
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(basket[i][j]==1)
                   {
                       allRotted = false ;
                       break ;
                   }
            }
        }
       return allRotted?time-1:-1;
    }
}