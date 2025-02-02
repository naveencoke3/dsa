package linkedlist;

public class Node {
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
        next = null;
    }

    public static void printNode(Node node){
        while(node!=null){
            System.out.println(node.data);
            node = node.next;
        }
    }
}
