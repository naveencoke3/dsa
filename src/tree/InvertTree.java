package tree;

public class InvertTree {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(9);
        System.out.println(root);
        new InvertTree().invert(root);
        System.out.println(root);
    }

    public void invert(Node root){
        if(root==null){
            return;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right= temp;
        invert(root.left);
        invert(root.right);
    }
}
