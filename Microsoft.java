public class Microsoft {
    static class Node{
        int data ;
        Node left, right ;
        public Node(int data){
            this.data = data ;
            this.left = this.right = null ;
        }
    }
    public static Node root = null ;
    //method to print the nodes at distance k down the root
    public static void printAllTheWayDown(Node root,int k){
        if(root == null || k < 0)
            return ;
        if(k==0){
            System.out.print(root.data);
            System.out.println();
            return ;
        }
        printAllTheWayDown(root.left, k-1);
        printAllTheWayDown(root.right, k-1);
    }
   public static int search(Node root,Node target, int k){
       
    if(root==null){
           return -1 ;
       }
       if(root.data == target.data){
           printAllTheWayDown(root, k);
           return 0 ;
       }
       int ld = search(root.left, target, k) ;
       if(ld!=-1){
           if(ld + 1 == k){
               System.out.println(root.data);
               System.out.println();
           }else{
               printAllTheWayDown(root.right, k-ld-2);
           }
           return ld + 1 ;
       }
       int rd = search(root.right, target, k) ;
       if(rd!=-1){
           if(rd + 1 == k){
               System.out.println(root.data);
               System.out.println();
           }else{
               printAllTheWayDown(root.left, k-rd-2);
           }
           return rd + 1 ;
       }
       return -1 ;
   }
    
    public static void main(String[] args) {
        /* Let us construct the tree shown in above diagram */
        root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        Node target = root.left.right ;
        search(root,target,2) ;
    }
}