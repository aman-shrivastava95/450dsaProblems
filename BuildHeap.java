//finlally understood the heapify algorithm 
public class BuildHeap{

    static int extratMax(int[] arr){
        int n = arr.length ;
        int result = arr[0] ;//this will be the max element ;
        //swap root value with the last value
        arr[0] = arr[n-1] ;
        //we need to call hepify  on the root
        //size will be reduced to  1 
        heapify(arr, n-1, 0);
        return result ;
    }
    static void heapify(int[] arr, int n, int i){
        int left = 2*i + 1 ;
        int right = 2*i + 2 ;
        int largest = i ;
        //if left child is larger than root
        if(left <n && arr[left] >=arr[largest]){
            largest = left ;
        }
        // if right child is larger by far
        if(right <n && arr[right] >=arr[largest]){
            largest = right ;
        }
        //if largest is not the root  then we need to swap items and call hepify on affected subtree
        if(largest != i){
            int temp = arr[i] ;
            arr[i]  = arr[largest] ;
            arr[largest] = temp ;
            heapify(arr, n, largest);
        }
    }

    //merthod to build the heap from array
    public static void buildHeap(int[] arr, int n){
        //we do not need to hepify the leave nodes as they aleady follow the heap property
        //we will be hepifying from the last non leaf to first as hepify can be calleda that node only which have their subtrees alredy heapified
        int start = n/2 -1 ;
        for(int i = start ;i>=0;i--){
            heapify(arr, n, i) ;
        }
    }
    //driver method
    public static void main(String[] args) {
        //have to build array from this arr
        int arr[] = { 1, 3, 5, 4, 6, 13, 10,
            9, 8, 15, 17 }; 
        buildHeap(arr,arr.length) ;    
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(extratMax(arr));
        for(int i : arr){
            System.out.print(i + " ");
        }

    }
}