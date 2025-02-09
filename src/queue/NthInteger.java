package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
NOTE: All the A integers will fit in 32-bit integers.
Input 1:
 A = 7
 Output 1:
  [1, 2, 3, 11, 12, 13, 21]
Explanation 2:
 Output denotes the first 7 integers that contains only digits 1, 2 and 3.
 */
public class NthInteger {
    public static void main(String[] args) {
        System.out.println(new NthInteger().solve(7));
    }
    public ArrayList<Integer> solve(int A) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        if(A==1){
            return res;
        }
        res.add(2);
        if(A==2){
            return res;
        }
        res.add(3);
        if(A==3){
            return res;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        int i=4;
        while(i<=A){
            int x =  q.poll();
            int a = x*10+1;
            int b = x*10+2;
            int c = x*10+3;
            res.add(a);
            if(i==A){
                return res;
            }
            res.add(b);
            if(i+1==A){
                return res;
            }
            res.add(c);
            if(i+2==A){
                return res;
            }
            q.add(a);
            q.add(b);
            q.add(c);
            i+=3;
        }
        return res;
    }
}
