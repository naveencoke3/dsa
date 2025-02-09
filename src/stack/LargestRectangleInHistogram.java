package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given an array of integers A.
A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
Find the area of the largest rectangle formed by the histogram.
Input 1:
 A = [2, 1, 5, 6, 2, 3]
 Output 1:
 10
 Explanation 1:
The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(List.of(2, 1, 5, 6, 2, 3)));
    }
    public int largestRectangleArea(List<Integer> A) {
        ArrayList<Integer> lse = getLeftSmaller(A);
        ArrayList<Integer> rse = getRightSmaller(A);
        int ans = 0;
        for(int i=0;i<A.size();i++){
            int ls = lse.get(i);
            int rs = rse.get(i)==-1?A.size():rse.get(i);
            ans = Math.max(ans,A.get(i)*(rs-ls-1));
        }
        return ans;
    }

    public ArrayList<Integer> getLeftSmaller(List<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            while(!stack.isEmpty() && A.get(stack.peek())>=A.get(i)){
                stack.pop();
            }
            Integer pushEle = stack.isEmpty()?-1:stack.peek();
            result.add(pushEle);
            stack.push(i);
        }
        return result;
    }

    public ArrayList<Integer> getRightSmaller(List<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            result.add(0);
        }
        for(int i=A.size()-1;i>=0;i--){
            while(!stack.isEmpty() && A.get(stack.peek())>=A.get(i)){
                stack.pop();
            }
            Integer pushEle = stack.isEmpty()?-1:stack.peek();
            result.set(i,pushEle);
            stack.push(i);
        }
        return result;
    }
}
