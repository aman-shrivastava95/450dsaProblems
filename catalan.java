//this is the dp implementation of finding the catalan number, huget variety of questions is directly or indirectly a variant of catalan number
/*
number of bsts
unlabled tree (for labled tree, just multiply it with n!)
N paranthesis (with and without letters)
Dyck words
Mountain ranges
Path on Grid (have to stay always above or below the diagonal)
Convex polygon
connect disjoint chords
ways of triangulisation
 */
public class catalan{
    public static void main(String[] args) {
        System.out.println(findCatalanDp(4));
    }

   static int findCatalanDp(int n){
       int catalan[] = new int[n+1] ;
       catalan[0] = 1 ;
       catalan[1] = 1 ;
       for(int i = 2;i<=n;i++){
         catalan[i] = 0 ;
         for(int j = 0 ;j<i;j++){
             catalan[i]+=catalan[j]*catalan[i-j-1] ;
         }
       }
       return catalan[n] ;
   }
    
}