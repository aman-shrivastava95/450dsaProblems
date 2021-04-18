

class Node{
    int data ;
    Node left, right ;
    public Node(int data){
        this.data = data;
    }
}

class sumPath{
    static int maxLen = 0 ;
    static int maxSum  = 0 ;
    static class LenSum{
        int len ;
        int sum ;
    } ;
    public static LenSum maxSum(Node root){
        LenSum ret = new LenSum() ;
        if( root == null){
            ret.len = 0;
            ret.sum = 0 ;
            return ret ;
        }
        //for a given root, we will recieve the length coming from its left and length coming from its right
        // whichever is bigger ,we will take the sum from that side
        LenSum l = maxSum(root.left)  ;
        LenSum r = maxSum(root.right) ;
        ret.len = Math.max(l.len,r.len) + 1 ;
        ret.sum = l.len >r.len?l.sum + root.data:r.sum + root.data;
        return ret ;
    }
    
    public static void anotherMaxSum(Node root,int sum, int len){
        if( root == null){
            if(len >maxLen){
                maxLen = len ;
                if(sum > maxSum)
                    maxSum  = sum ;
            }
            return ;
        }

        anotherMaxSum(root.left, sum+root.data, len+1);
        anotherMaxSum(root.right, sum+root.data, len+1);

    }
    public static void main(String[] args) {
        // binary tree formation
        Node root = new Node(4);         /*        4        */
        root.left = new Node(2);         /*       / \       */
        root.right = new Node(5);        /*      2   5      */
        root.left.left = new Node(7);    /*     / \ / \     */
        root.left.right = new Node(1);   /*    7  1 2  3    */
        root.right.left = new Node(2);   /*      /          */
        root.right.right = new Node(3);  /*     6           */
        root.left.right.left = new Node(6);

        System.out.println(maxSum(root).sum);
        System.out.println();
        anotherMaxSum(root, 0, 0);
        System.out.println(maxSum);
    }
}