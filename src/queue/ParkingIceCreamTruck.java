package queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ParkingIceCreamTruck {
    public static void main(String[] args) {
        System.out.println(new ParkingIceCreamTruck().slidingMaximum(List.of(1,8,5,6,7,4,2,0,3),4));
    }

    public List<Integer> slidingMaximum(List <Integer> A, int B){
        Deque<Node> deque = new LinkedList<>();
        int i=0;
        ArrayList<Integer> res = new ArrayList < > ();
        for(i=0;i<B;i++){
            while (!deque.isEmpty()&& deque.peekFirst().val<=A.get(i)){
                deque.pollFirst();
            }
            deque.addFirst(new Node(i,A.get(i)));
        }
        res.add(deque.peekLast().val);
        for(;i<A.size();i++){
            int val = A.get(i);
            while (!deque.isEmpty() && (i - deque.peekLast().index >= B)) {
                deque.pollLast();
            }
            while (!deque.isEmpty() && deque.peekFirst().val <= val) {
                deque.pollFirst();
            }
            deque.addFirst(new Node(i, val));
            Node ans = deque.peekLast();
            res.add(ans.val);
        }
        return res;
    }

    class Node{
        int val;
        int index;
        Node(int index,int val){
            this.val = val;
            this.index = index;
        }
    }
}
