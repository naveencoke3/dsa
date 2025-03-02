package tree;

public class HeightBalancedTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
        System.out.println("IsHeightBalanced - "+new HeightBalancedTree().checkHeight(root).isHeightBalanced);
    }

    public class Pair{
        boolean isHeightBalanced;
        int height;
        public Pair(boolean isHeightBalanced,int height){
            this.height =height;
            this.isHeightBalanced  = isHeightBalanced;
        }
    }

    private Pair checkHeight(Node root) {
        if(root==null){
            return new Pair(true,-1);
        }
        Pair left = checkHeight(root.left);
        Pair right = checkHeight(root.right);
        return new Pair((left.isHeightBalanced && right.isHeightBalanced && Math.abs(left.height-right.height)<=1),1+Math.max(left.height,right.height));
    }

}
