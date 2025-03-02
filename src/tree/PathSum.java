package tree;

public class PathSum {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left  =new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        System.out.println(new PathSum().hasPathSum(root,22));
    }

    public boolean hasPathSum(Node root,int k){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            return (k== root.data);
        }
        return hasPathSum(root.left,k- root.data)||hasPathSum(root.right,k-root.data);
    }
}
