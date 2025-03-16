package heap;

import tree.Node;

import java.util.ArrayList;
import java.util.List;

/*
Given a list containing head pointers of N sorted linked lists.
Merge these given sorted linked lists and return them as one sorted list.
Input 1:
 1 -> 10 -> 20
 4 -> 11 -> 13
 3 -> 8 -> 9
 Output 1:
 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 Explanation 1:
 The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
 */
public class MergeKSortedList {
    public static void main(String[] args) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode node = new ListNode(1);
        node.next = new ListNode(6);
        /*node.next.next = new ListNode(20);
        list.add(node);
        node = new ListNode(4);
        node.next = new ListNode(11);
        node.next.next = new ListNode(13);
        list.add(node);
        node = new ListNode(3);
        node.next = new ListNode(8);
        node.next.next = new ListNode(9);*/
        list.add(node);
        ListNode resultNode = new MergeKSortedList().mergeKLists(list);
        System.out.println(resultNode);
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        List<Pair> minHeap = new ArrayList<>();
        for(int i=0;i<a.size();i++){
            insert(minHeap,a.get(i),i);
        }
        Pair pair = extractMin(minHeap);
        ListNode node = new ListNode(pair.node.val);
        ListNode temp = node;
        ListNode availablePair = a.get(pair.index);
        availablePair = availablePair.next;
        a.set(pair.index, availablePair);
        while (!minHeap.isEmpty()){
            if(a.get(pair.index)!=null)
                insert(minHeap,a.get(pair.index), pair.index);
            pair = extractMin(minHeap);
            temp.next = new ListNode(pair.node.val);
            temp = temp.next;
            availablePair = a.get(pair.index);
            availablePair = availablePair.next;
            a.set(pair.index, availablePair);
        }
        return node;
    }

    public Pair extractMin(List<Pair> input){
        heapify(input,0);
        swap(input,0, input.size()-1);
        Pair result = input.getLast();
        input.remove(input.size()-1);
        heapify(input,0);
        return result;
    }

    public void heapify(List<Pair> input,int i){
        int x;
        while((2*i)+1<input.size()){
            if((2*i)+2<input.size()){
                x = Math.min(input.get(i).node.val,Math.min(input.get((2*i)+1).node.val,input.get((2*i)+2).node.val));
            }else{
                x = Math.min(input.get(i).node.val,input.get((2*i)+1).node.val);
            }
            if(x==input.get(i).node.val){
                break;
            }
            if(x==input.get((2*i)+1).node.val){
                swap(input,i,(2*i)+1);
                i = (2*i)+1;
            }else if(x==input.get((2*i)+2).node.val){
                swap(input,i,(2*i)+2);
                i = (2*i)+2;
            }
        }
    }

    public void insert(List<Pair> input, ListNode data,int index){
        input.add(new Pair(index,data));
        int i=input.size()-1;
        while(i>0){
            int parentIndex = (i-1)/2;
            if(input.get(parentIndex).node.val>input.get(i).node.val){
                swap(input,parentIndex,i);
                i=parentIndex;
            }else
                break;
        }
    }
    public void swap(List<Pair> input, int i, int j){
        Pair temp = input.get(i);
        input.set(i,input.get(j));
        input.set(j,temp);
    }
    public void swapListNode(List<ListNode> input, int i, int j){
        ListNode temp = input.get(i);
        input.set(i,input.get(j));
        input.set(j,temp);
    }

    class Pair{
        int index;
        ListNode node;
        public Pair(int index,ListNode node){
            this.index = index;
            this.node = node;
        }
    }
}
