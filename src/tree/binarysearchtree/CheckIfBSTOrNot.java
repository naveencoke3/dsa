package tree.binarysearchtree;

import tree.Node;

public class CheckIfBSTOrNot {
    int prev=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right =new Node(7);
        System.out.println(new CheckIfBSTOrNot().isBST(root));
    }

    public boolean isBST(Node root){
        if(root==null){
            return true;
        }
        if(!isBST(root.left)){
            return false;
        }
        if(root.data<prev){
            return false;
        }
        prev = root.data;
        return isBST(root.right);
    }
}
