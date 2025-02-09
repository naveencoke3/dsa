package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
Given an array of integers A.
The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.
Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
Input 2:
 A = [4, 7, 3, 8]
 Output 2:
 26
 Explanation 2:
value ( [4] ) = 4 - 4 = 0
value ( [7] ) = 7 - 7 = 0
value ( [3] ) = 3 - 3 = 0
value ( [8] ) = 8 - 8 = 0
value ( [4, 7] ) = 7 - 4 = 3
value ( [7, 3] ) = 7 - 3 = 4
value ( [3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3] ) = 7 - 3 = 4
value ( [7, 3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3, 8] ) = 8 - 3 = 5
sum of values % 10^9+7 = 26
 */
public class MaxAndMinOfSubArray {
    public static void main(String[] args) {
        System.out.println(new MaxAndMinOfSubArray().solve(new ArrayList<>(List.of(4, 7, 3, 8))));
    }
    public long solve(ArrayList<Integer> A) {
        ArrayList<Integer> lse = getLeftSmaller(A);
        ArrayList<Integer> rse = getRightSmaller(A);
        ArrayList<Integer> lsg = getLeftGreater(A);
        ArrayList<Integer> rsg = getRightGreater(A);
        long ans = 0;
        for(int i=0;i<A.size();i++){
            ans+=(A.get(i)*((i-lsg.get(i))*(rsg.get(i)-i))%1000000007)%1000000007-(A.get(i)*((i-lse.get(i))*(rse.get(i)-i))%1000000007)%1000000007;
        }
        return ans%1000000007;
    }

    public ArrayList<Integer> getLeftSmaller(ArrayList<Integer> A) {
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

    public ArrayList<Integer> getRightSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            result.add(0);
        }
        for(int i=A.size()-1;i>=0;i--){
            while(!stack.isEmpty() && A.get(stack.peek())>=A.get(i)){
                stack.pop();
            }
            Integer pushEle = stack.isEmpty()?A.size():stack.peek();
            result.set(i,pushEle);
            stack.push(i);
        }
        return result;
    }

    public ArrayList<Integer> getLeftGreater(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            while(!stack.isEmpty() && A.get(stack.peek())<=A.get(i)){
                stack.pop();
            }
            Integer pushEle = stack.isEmpty()?-1:stack.peek();
            result.add(pushEle);
            stack.push(i);
        }
        return result;
    }

    public ArrayList<Integer> getRightGreater(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            result.add(0);
        }
        for(int i=A.size()-1;i>=0;i--){
            while(!stack.isEmpty() && A.get(stack.peek())<=A.get(i)){
                stack.pop();
            }
            Integer pushEle = stack.isEmpty()?A.size():stack.peek();
            result.set(i,pushEle);
            stack.push(i);
        }
        return result;
    }
}
