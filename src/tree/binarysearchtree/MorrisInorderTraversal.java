package tree.binarysearchtree;

import tree.Node;

public class MorrisInorderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.right = new Node(6);
        root.left.right.right = new Node(7);
        new MorrisInorderTraversal().morrisInorderTraversal(root);
    }

    public void morrisInorderTraversal(Node root){
        Node curr = root;
        while(curr!=null){
            if(curr.left==null){
                System.out.println(curr.data);
                curr = curr.right;
            }else{
                Node pre = curr.left;
                 while(pre.right!=null && pre.right!=curr){
                    pre = pre.right;
                }
                if(pre.right==null){
                    pre.right = curr;
                    curr = curr.left;
                }else {
                    pre.right = null;
                    System.out.println(curr.data);
                    curr = curr.right;
                }
            }
        }
    }
}
