package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

/*
Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.


More formally,

G[i] for an element A[i] = an element A[j] such that

j is maximum possible AND

j < i AND

A[j] < A[i]

Elements for which no smaller element exist, consider the next smaller element as -1.

Input 1:

 A = [4, 5, 2, 10, 8]
 Output 1:

 [-1, 4, -1, 2, 2]
 Explanation 1:

index 1: No element less than 4 in left of 4, G[1] = -1
index 2: A[1] is only element less than A[2], G[2] = A[1]
index 3: No element less than 2 in left of 2, G[3] = -1
index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]
 */
public class NearestSmallestElement {
    public static void main(String[] args) {
        System.out.println(new NearestSmallestElement().findNearestSmallestElementUsingStream(List.of(4, 5, 2, 10, 8)));
    }
    public static List<Integer> findNearestSmallestElementUsingStream(List<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        return IntStream.range(0, list.size())
                .mapToObj(i -> {
                    while (!stack.isEmpty() && stack.peek() >= list.get(i)) {
                        stack.pop();
                    }
                    Integer res = stack.isEmpty() ? -1 : stack.peek();
                    stack.push(list.get(i));
                    return res;
                })
                .toList();
    }
    public ArrayList<Integer> findNearestSmallestElement(List<Integer> list){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            while(!stack.isEmpty() && stack.peek()>=list.get(i)){
                stack.pop();
            }
            Integer res = stack.isEmpty()?-1:stack.peek();
            result.add(res);
            stack.push(list.get(i));
        }
        return result;
    }
}
