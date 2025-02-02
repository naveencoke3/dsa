package linkedlist;

/*
You are given a singly linked list having head node A. You have to reverse the linked list and return the head node of that reversed list.

NOTE: You have to do it in-place and in one-pass.

 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        new ReverseLinkedList().reverseLinkedList(node);
    }

    public void reverseLinkedList(Node node){
        if(node==null){
            return;
        }
        if(node.next==null){
            Node.printNode(node);
            return;
        }
        Node curr = node,next= node.next;
        Node prev = null;
        while(next!=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
        }
        curr.next = prev;
        Node.printNode(curr);
    }
}
