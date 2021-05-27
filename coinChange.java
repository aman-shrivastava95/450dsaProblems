import java.util.HashSet;
import java.util.Set;

public class coinChange{
    
    static Set<Integer> set = new HashSet<>() ;
    public static void main(String[] args) {
        
        int[] arr = {1,5,10} ;
        countR(4,arr) ;
        System.out.println( countR(12,arr));
        System.out.println(coinCount(12,0,arr));
        
    }

    private static int  countR(int N, int arr[]) {
        int ways[] = new int[N + 1] ; 
        //base case 
        ways[0] = 1 ;
        //iterate over all the coins
        for(int i = 0;i<arr.length;i++){
            int currCoin = arr[i] ;
            //lets. try to use current coin for all our target number
            for(int j = 0;j<ways.length;j++){
                //it i use the current coin then I have to increament it by ways of the state it takes me to 
                if(currCoin <= j){
                    ways[j]+=ways[j-currCoin] ;
                }
            }
        } 
        return ways[ways.length -1] ;
    }
    private static int coinCount(int N, int start , int arr[]){
        if(N==0) return 1 ;
        if(N< 0) return 0 ;
        if(start>=arr.length) return  0 ;
        //either I can take the current coin or I can leave the current coin and sum them both
         return coinCount(N-arr[start], start, arr) + coinCount(N, start+1, arr) ;
    }
}