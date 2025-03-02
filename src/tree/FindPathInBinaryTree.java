package tree;

import java.util.ArrayList;
import java.util.List;

public class FindPathInBinaryTree {
    static List<Node> list = new ArrayList<>();
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(6);
        root.right.left = new Node(9);
        root.right.right = new Node(2);
        root.right.left.left = new Node(4);
        root.right.left.right = new Node(8);
        root.right.left.right.left = new Node(3);
        new FindPathInBinaryTree().findPath(root,8);
        System.out.println(list);
    }
    public void findPath(Node root,int k){
        if(root ==null){
            return;
        }
        if(root.data == k){
            list.add(root);
            return;
        }
        findPath(root.left,k);
        if(list.size()>0){
            list.add(root);
            return;
        }
        findPath(root.right,k);
        if(list.size()>0){
            list.add(root);
            return;
        }
    }
}
