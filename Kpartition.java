import java.util.ArrayList;

//the crux of the problem is that every element will have two choices , either to go in any among the exsting non-empty sets, or
// go in the first non empty set.
public class Kpartition{

    private static void partition( ArrayList<ArrayList<Integer>> ans,int i, int n,int k, int setSoFar){
        //check for the base cases
        if(i > n){
            if(setSoFar==k){
                for(ArrayList<Integer> set : ans){
                    System.out.print(set);
                }
                System.out.println();
            }
            return ;
        }

       for(int j=0;j<ans.size();j++){
           if(ans.get(j).size() > 0){
               ans.get(j).add(i) ;
               partition(ans, i+1, n, k, setSoFar);//setSoFar will not incrase , as we choose not to create any new set at this point
               ans.get(j).remove(ans.get(j).size()-1) ;//back tracking step to remove last number we added
           }else{
               //this will be the first non empty set, in our case the second choice
               ans.get(j).add(i) ;
               partition(ans, i+1, n, k, setSoFar+1);
               ans.get(j).remove(ans.get(j).size()-1) ;
               break;//we don't want permutations of the set 
           }
       }

    }

    public static void main(String[] args) {
        int n =4 ;
        int k = 3  ;
        ArrayList<ArrayList<Integer>> ans =  new ArrayList<>() ;//to store different sets
        for(int i=0;i<k;i++){
            ans.add(new ArrayList<Integer>());
        }
        partition(ans,1,n,k,0) ;
    }
}