import java.util.ArrayList;
import java.util.List;


//this question is on leetcode
class Solution {
    
    List<List<Integer>>  result = new ArrayList<>() ;

    public List<List<Integer>> permute(int[] nums) {
        permuteUtil(nums, 0 , nums.length-1) ;
        return result ;
    }

    private void permuteUtil(int[] nums, int l, int r) {
        if( l == r){
           List<Integer> items = new ArrayList<>() ;
           for(int i = 0;i<nums.length;i++)
                items.add(nums[i]) ;
            result.add(items);
            
            
        }else{
            for(int i = l;i<=r;i++){
                //swap the elemtns at i and l
                int temp = nums[l] ;
                nums[l] = nums[i] ;
                nums[i] = temp ;

                //recur over other numbers
                permuteUtil(nums,l+1,r) ;

                //swap again to backtrack
                 temp = nums[l] ;
                nums[l] = nums[i] ;
                nums[i] = temp ;

            }
        }
    }
}