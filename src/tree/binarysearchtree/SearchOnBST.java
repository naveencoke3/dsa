package tree.binarysearchtree;

import tree.Node;

public class SearchOnBST {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left=new Node(1);
        root.left.right = new Node(4);
        root.right.left=new Node(6);
        root.right.right=new Node(9);
        Node findedRoot = new SearchOnBST().find(root,6);
        System.out.println(findedRoot!=null? findedRoot.data:null);
    }

    private Node find(Node root, int val) {
        if(root==null){
            return null;
        }
        if(val==root.data){
            return root;
        }else if (root.data>val){
            return find(root.left,val);
        }else{
            return find(root.right,val);
        }
    }

}
