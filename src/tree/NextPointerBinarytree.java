package tree;

import java.util.LinkedList;
import java.util.Queue;

public class NextPointerBinarytree {
    public static void main(String[] args) {
        NextPointerNode root = new NextPointerNode(1);
        root.left = new NextPointerNode(2);
        root.right = new NextPointerNode(3);
        root.left.left = new NextPointerNode(4);
        root.left.right = new NextPointerNode(5);
        root.right.left = new NextPointerNode(6);
        root.right.right = new NextPointerNode(7);
        new NextPointerBinarytree().connect(root);
        System.out.println(root);
    }

    public void connect(NextPointerNode root){
        if(root==null){
            return;
        }
        Queue<NextPointerNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i=0;i<queueSize;i++){
                NextPointerNode node = queue.poll();
                if(i<queueSize-1){
                    node.next = queue.peek();
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
    }
}
