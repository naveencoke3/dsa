package tree.binarysearchtree;

import tree.Node;

public class DeleteOnBST {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(24);
        root.left.left = new Node(5);
        root.left.right = new Node(15);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(12);
        root.left.right.right = new Node(18);
        Node afterDelete = new DeleteOnBST().delete(root,10);
        System.out.println(afterDelete);
    }

    public Node delete(Node root,int val){
        if(root==null){
            return root;
        }
        if(root.data==val){
            if(root.left==null && root.right==null){
                return null;
            }
            if(root.left==null || root.right==null){
                if(root.left==null){
                    return root.right;
                }else {
                    return root.left;
                }
            }
            Node temp = root.left;
            while (temp.right!=null){
                temp = temp.right;
            }
            root.data = temp.data;
            root.left = delete(root.left, temp.data);
        } else if (root.data>val) {
            root.left = delete(root.left,val);
        }else{
            root.right = delete(root.right,val);
        }
        return root;
    }
}
