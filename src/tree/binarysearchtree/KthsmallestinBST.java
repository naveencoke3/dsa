package tree.binarysearchtree;

import tree.Node;

import java.util.ArrayList;

public class KthsmallestinBST {
    static ArrayList<Integer> inorderedArr = new ArrayList<>();
    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(9);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.left = new Node(8);
        root.left.left.right = new Node(2);
        new KthsmallestinBST().findInOrder(root);
        System.out.println(inorderedArr.get(6-1));
    }
    public void findInOrder(Node root){
        if(root==null){
            return;
        }
        findInOrder(root.left);
        inorderedArr.add(root.data);
        findInOrder(root.right);
    }
}
