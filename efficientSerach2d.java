class Solution {
    //the idea is to treat it as a single dimesnsion array and then map the index to row and column
    public boolean searchMatrix(int[][] matrix, int target) {
        int colSize = matrix[0].length ;
        int lo = 0 ; 
        int hi = matrix.length*matrix[0].length -1 ;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2 ;
            //here is the mapping to row and col
            int ri = mid/colSize ;
            int ci = mid%colSize ;
            if(target == matrix[ri][ci])
                return true ;
            else if(target < matrix[ri][ci])
                hi = mid -1 ;
            else
                lo = mid +1 ;
         }
         return false ;
    }
}