package linkedlist;

public class CopyListWithRandomPointer {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList(8);
        DoublyLinkedList list1 = new DoublyLinkedList(9);
        DoublyLinkedList list2 = new DoublyLinkedList(12);
        DoublyLinkedList list3 = new DoublyLinkedList(10);
        DoublyLinkedList list4 = new DoublyLinkedList(20);
        list.next = list1;
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list.random = list4;
        list1.random = list1;
        list2.random = list;
        list3.random = list2;
        list4.random = list2;
        DoublyLinkedList copied = new CopyListWithRandomPointer().copyLinkedList(list);
        System.out.println(list+" "+copied);
    }

    public DoublyLinkedList copyLinkedList(DoublyLinkedList list){
        DoublyLinkedList temp = list;
        while(temp!=null){
            DoublyLinkedList newNode = new DoublyLinkedList(temp.data);
            DoublyLinkedList nextNode = temp.next;
            temp.next = newNode;
            newNode.next = nextNode;
            temp = newNode.next;
        }
        DoublyLinkedList temp1 = list;
        while (temp1!=null){
            temp1.next.random = temp1.random.next;
            temp1 = temp1.next.next;
        }
        DoublyLinkedList temp2 = list;
        DoublyLinkedList copyList = temp2.next;
        DoublyLinkedList tempCopy = copyList;
        while (temp2!=null){
            tempCopy = temp2.next;
            temp2.next = tempCopy.next;
            tempCopy.next = temp2.next!=null?temp2.next.next:null;
            temp2 = temp2.next;
        }
        return copyList;
    }

    public static class DoublyLinkedList{
        int data;
        DoublyLinkedList next;
        DoublyLinkedList random;
        public DoublyLinkedList(int data){
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }
}
