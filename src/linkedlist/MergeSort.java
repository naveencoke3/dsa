package linkedlist;

public class MergeSort {
    public static void main(String[] args) {
        Node node = new Node(3);
        node.next = new Node(4);
        node.next.next = new Node(8);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(5);
        Node sortedNode = new MergeSort().mergeSort(node);
        Node.printNode(sortedNode);

    }

    public Node mergeSort(Node node){
        if(node==null || node.next==null){
            return node;
        }
        Node middle = findMiddle(node);
        Node node2 = middle.next;
        middle.next = null;
        node = mergeSort(node);
        node2 = mergeSort(node2);
        return new MergeSort().mergeNode(node,node2);
    }

    public Node mergeNode(Node node1,Node node2){
        if(node1==null){
            return node2;
        }
        if(node2==null){
            return node1;
        }
        Node mergedList = null;
        if(node1.data< node2.data){
            mergedList = node1;
            node1 = node1.next;
        } else if (node2.data< node1.data) {
            mergedList = node2;
            node2 = node2.next;
        }
        Node curr = mergedList;
        while(node1!=null && node2!=null){
            if(node1.data< node2.data){
                curr.next = node1;
                node1=node1.next;
            }else {
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;
        }
        if(node2!=null){
            curr.next = node2;
        }else if(node1!=null){
            curr.next = node1;
        }
        return mergedList;
    }

    public Node findMiddle(Node node){
        if(node==null){
            System.out.println(node.data);
        }
        Node slow = node, fast = node;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
