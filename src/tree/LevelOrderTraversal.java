package tree;

import java.util.LinkedList;
import java.util.Queue;

/*
This is known as Breadth First traversal
 */
public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(5);
        root.left.right = new Node(8);
        root.right.right = new Node(13);
        root.left.left.left = new Node(6);
        root.right.right.left = new Node(10);
        root.right.right.right = new Node(15);
        root.right.right.left.left = new Node(9);
        root.right.right.left.right = new Node(11);
        new LevelOrderTraversal().levelOrderTraversal(root);
        new LevelOrderTraversal().printRightView(root);
    }

    private void printRightView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node last = root;
        Node newLast = null;
        System.out.println("===========RIght view=================");
        while(!queue.isEmpty()){
            Node x= queue.poll();
            if(x.left!=null){
                queue.add(x.left);
                newLast = x.left;
            }
            if(x.right!=null){
                queue.add(x.right);
                newLast = x.right;
            }
            if(last==x){
                System.out.println(x.data);
                last=newLast;
            }
        }
    }

    public void levelOrderTraversal(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        Node last = root;
        Node newLast = null;
        while(!queue.isEmpty()){
            Node x= queue.poll();
            System.out.println("level - "+level+" node - "+x.data);
            if(x.left!=null){
                queue.add(x.left);
                newLast = x.left;
            }
            if(x.right!=null){
                queue.add(x.right);
                newLast = x.right;
            }
            if(last==x){
                level++;
                last=newLast;
            }
        }
    }
}
