package linkedlist;

public class CircularLinkedList {
    public static void main(String[] args) {
        Node node = new Node(3);
        node.next = new Node(4);
        node.next.next = new Node(8);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = node;
        System.out.println(new CircularLinkedList().findContainsCircular(node));
    }

    public boolean findContainsCircular(Node node){
        Node slow = node,fast = node;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
