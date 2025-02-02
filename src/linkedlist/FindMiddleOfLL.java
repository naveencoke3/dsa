package linkedlist;

public class FindMiddleOfLL {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        new FindMiddleOfLL().printMiddle(node);
    }

    public void printMiddle(Node node){
        if(node==null){
            System.out.println(node.data);
        }
        Node slow = node, fast = node;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
    }
}
