package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
You have an empty min heap. You are given an array A consisting of N queries. Let P denote A[i][0] and Q denote A[i][1]. There are two types of queries:

P = 1, Q = -1 : Pop the minimum element from the heap.
P = 2, 1 <= Q <= 109 : Insert Q into the heap.

Return an integer array containing the answer for all the extract min operation. If the size of heap is 0, then extract min should return -1.

Input 1:

A = [[1, -1], [2, 2], [2, 1], [1, -1]]
Example Output

Output 1:

[-1, 1]
Explanation 1:

For the first extract operation the heap is empty so it gives -1. For the second extract operation the heap contains the elements 2 and 1. Extract min returns the element 1.
 */
public class HeapBasedOnPriorityQueue {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>(List.of(new ArrayList<>(List.of(1,-1)),new ArrayList<>(List.of(2,2)),new ArrayList<>(List.of(2,1)),new ArrayList<>(List.of(1,-1))));
        System.out.println(new HeapBasedOnPriorityQueue().solve(input));
    }

    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ArrayList<Integer> query : A) {
            int p = query.get(0);
            int q = query.get(1);

            if (p == 1) {
                result.add(pq.isEmpty() ? -1 : pq.remove());
            } else if (p == 2) {
                pq.add(q);
            }
        }
        return result;
    }
}
