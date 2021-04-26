import java.util.Stack;

public class balancesparanthsis {

    public int score(String s, int lo, int hi,int[] endings){
        if( hi == lo+1){
            return 1 ;
            //this is the  base case '()'
        }
            int mid = endings[lo] ;
    
            if(mid==hi)
                return 2*score(s, lo+1,hi-1,endings) ;
            else 
                return score(s, lo, mid, endings)+ score(s, mid+1, hi, endings) ;
        
    }

    //to find the corresponding closing paranthesis indices.    
    public static int[] findIndex(String str){
       int[] indexes = new int[str.length()] ;//all will be intitally zero
        Stack<Integer> s =  new Stack<>()   ;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==')'){
                int top = s.peek() ;
                indexes[top] = i ;
                s.pop() ;
            }else{
                s.push(i) ;
            }
        }
        return indexes ;

    }
    public static void main(String[] args) {
        String s = "(())()((()))" ;
        int[] indexes = findIndex(s) ;
        for(int i = 0;i<indexes.length;i++){
            System.out.println(i + "->" + indexes[i]);
        }
    }
}