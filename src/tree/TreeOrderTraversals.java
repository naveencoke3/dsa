package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeOrderTraversals {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(8);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(18);
        List<Integer> preOrder = new ArrayList<>();
        new TreeOrderTraversals().preOrderTraversal(root,preOrder);
        System.out.println(preOrder);
        List<Integer> inOrder = new ArrayList<>();
        new TreeOrderTraversals().inOrderTraversal(root,inOrder);
        System.out.println(inOrder);
        List<Integer> postOrder = new ArrayList<>();
        new TreeOrderTraversals().postOrderTraversal(root,postOrder);
        System.out.println(postOrder);
    }
    /*
        N->L->R
     */
    public void preOrderTraversal(Node node, List<Integer> list){
        if(node==null){
            return;
        }
        list.add(node.data);
        preOrderTraversal(node.left,list);
        preOrderTraversal(node.right,list);
    }

    public void inOrderTraversal(Node node, List<Integer> list){
        if(node==null){
            return;
        }
        inOrderTraversal(node.left,list);
        list.add(node.data);
        inOrderTraversal(node.right,list);
    }

    public void postOrderTraversal(Node node, List<Integer> list){
        if(node==null){
            return;
        }
        postOrderTraversal(node.left,list);
        postOrderTraversal(node.right,list);
        list.add(node.data);
    }
}
