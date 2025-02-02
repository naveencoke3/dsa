package linkedlist;

public class StartingPointOfCircularLL {
    public static void main(String[] args) {
        Node node = new Node(3);
        node.next = new Node(4);
        node.next.next = new Node(8);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = node.next;
        System.out.println(new StartingPointOfCircularLL().findStartingPointOfCircle(node).data);
        System.out.println("================Loop broke==============");
        Node.printNode(new StartingPointOfCircularLL().breakTheCircleLoop(node));
    }

    private Node breakTheCircleLoop(Node node) {
        Node slow = node,fast = node;
        boolean isCircle = false;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCircle = true;
                break;
            }
        }
        if(!isCircle){
            return null;
        }
        slow = node;
        Node prev = null;
        while(slow!=fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
        return node;
    }

    public Node findStartingPointOfCircle(Node node){
        Node slow = node,fast = node;
        boolean isCircle = false;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCircle = true;
                break;
            }
        }
        if(!isCircle){
            return null;
        }
        slow = node;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
