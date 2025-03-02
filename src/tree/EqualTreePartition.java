package tree;

public class EqualTreePartition {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(4);
        root.left.right = new Node(2);
        root.right.left = new Node(6);
        root.right.right = new Node(1);
        System.out.println(new EqualTreePartition().isEqualTreePartition(root));
    }

    public Boolean isEqualTreePartition(Node root){
        if(root==null){
            return false;
        }
        int totalSum = sum(root);
        if(totalSum%2==1){
            return false;
        }
        else{
            if(root.left==null && root.right==null){
                return false;
            }
            return hasPartsWithEqualSum(root,totalSum).isHalf;
        }
    }

    private Pair hasPartsWithEqualSum(Node root, int totalSum) {
        if(root==null){
            return new Pair(0,false);
        }
        Pair leftPair = hasPartsWithEqualSum(root.left,totalSum);
        Pair rightPair = hasPartsWithEqualSum(root.right,totalSum);
        int sum = leftPair.total+rightPair.total+root.data;
        boolean isHalf = leftPair.isHalf || rightPair.isHalf || sum*2==totalSum;
        return new Pair(sum,isHalf);
    }

    public int sum(Node root){
        if(root==null){
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum+rightSum+root.data;
    }

    class Pair{
        int total;
        boolean isHalf;
        Pair(int total,boolean isHalf){
            this.isHalf = isHalf;
            this.total = total;
        }
    }
}
