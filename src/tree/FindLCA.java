package tree;

import javax.naming.NoPermissionException;
import javax.swing.plaf.synth.SynthOptionPaneUI;

public class FindLCA {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(6);
        root.right = new Node(16);
        root.left.left = new Node(2);
        root.left.right = new Node(9);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(3);
        root.left.right.left = new Node(8);
        System.out.println(new FindLCA().findLCA(root,new Node(2),new Node(8)).data);
    }

    public Node findLCA(Node root, Node node1, Node node2){
        if(root==null || root.data==node1.data ||root.data==node2.data){
            return root;
        }
        Node leftLca = findLCA(root.left,node1,node2);
        Node rightLca = findLCA(root.right,node1,node2);
        if(leftLca!=null && rightLca!=null){
            return root;
        }else if(leftLca!=null){
            return leftLca;
        }
        return rightLca;
    }
}
