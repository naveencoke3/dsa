package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Flipkart is currently dealing with the difficulty of precisely estimating and displaying the expected delivery time for orders to a specific pin code. The existing method relies on historical delivery time data for that pin code, using the median value as the expected delivery time. As the order history expands with new entries, Flipkart aims to enhance this process by dynamically updating the expected delivery time whenever a new delivery time is added. The objective is to find the expected delivery time after each new element is incorporated into the list of delivery times. End Goal: With every addition of new delivery time, requirement is to find the median value.

Why Median ? The median is calculated because it provides a more robust measure of the expected delivery time The median is less sensitive to outliers or extreme values than the mean. In the context of delivery times, this is crucial because occasional delays or unusually fast deliveries (outliers) can skew the mean significantly, leading to inaccurate estimations.


Given an array of integers, A denoting the delivery times for each order. New arrays of integer B and C are formed, each time a new delivery data is encountered, append it at the end of B and append the median of array B at the end of C. Your task is to find and return the array C.

NOTE:

If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).

Input 1:

 A = [1, 2, 5, 4, 3]
 Output 1:

 [1, 1, 2, 2, 3]

 Explanation 1:



 Delivery Times      median
 [1]                   1
 [1, 2]                1
 [1, 2, 5]             2
 [1, 2, 5, 4]          2
 [1, 2, 5, 4, 3]       3
 */
public class RunningMedian {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 5, 4, 3));
        System.out.println(new RunningMedian().solve(list));
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        ArrayList<Integer> result = new ArrayList<>();
        maxHeap.add(A.get(0));
        result.add(A.get(0));
        for(int i=1;i<A.size();i++){
            if(maxHeap.peek()< A.get(i)){
                minHeap.add(A.get(i));
            }else{
                maxHeap.add(A.get(i));
            }
            if(minHeap.size()== maxHeap.size()+2){
                maxHeap.add(minHeap.poll());
            }else if(maxHeap.size()== minHeap.size()+2){
                minHeap.add(maxHeap.poll());
            }
            if(minHeap.size()>maxHeap.size()){
                result.add(minHeap.peek());
            }else if(minHeap.size()<maxHeap.size()){
                result.add(maxHeap.peek());
            }else{
                result.add(maxHeap.peek());
            }
        }
        return result;
    }
}
