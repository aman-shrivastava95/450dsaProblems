//the idea is to track how much open and close I have used at any point and make decision on the basis of that
//open can be used if it is lest than available opens
//close can be used only if prior to it, some opens have been used i.e(open < close)

public class BParanthesis {
    static int count = 0 ;
    public static void genreateParenthesis(int n, int open, int close,String s){
        //base case (if I have used all the closed one)
        if(close == n){
            count++ ;
            System.out.println(s);
            return ;
        }
        //check the next bracket I can use it open or close
        if(open < n)
            genreateParenthesis(n, open+1, close, s+"(");
        if(open > close)
            genreateParenthesis(n, open, close+1, s+ ")");    
    }
    public static void main(String[] args) {
        int n = 3 ;
        //current string
        String str = "" ;
        int open =0, close = 0 ;
        genreateParenthesis(n, open, close,str) ;
        System.out.println(count);

    }
}