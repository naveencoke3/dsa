package tree.binarysearchtree;

import tree.Node;

public class InsertOnBST {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left=new Node(1);
        root.left.right = new Node(4);
        root.right.left=new Node(6);
        root.right.right=new Node(9);
        System.out.println(new InsertOnBST().insert(root,7));
    }

    private Node insert(Node root, int val) {
        if(root==null){
            return new Node(val);
        }
        if(val< root.data){
            root.left = insert(root.left,val);
        }else{
            root.right = insert(root.right,val);
        }
        return root;
    }
}
