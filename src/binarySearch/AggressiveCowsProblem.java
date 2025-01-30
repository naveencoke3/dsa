package binarySearch;

/*
Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.

His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?

Input 1:

A = [1, 2, 3, 4, 5]
B = 3
Output 1:
2

Explanation 1:

 John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.

TC:O(nlogn)
SC:O(1)
 */

import java.util.List;

public class AggressiveCowsProblem {
    public static void main(String[] args) {
        System.out.println(new AggressiveCowsProblem().partition(List.of(2,6,11,14,19,25,30,39,43), 4));
    }

    public int partition(List<Integer> A, int B) {
        int low = 1;
        int high = A.get(A.size() - 1) - A.get(0);
        int ans = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (noOfCows(A, mid) >= B) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private int noOfCows(List<Integer> A, int mid) {
        return A.stream().skip(1).reduce(new int[]{A.get(0), 1}, (acc, val) -> {
            if (val - acc[0] >= mid) {
                acc[1]++;
                acc[0] = val;
            }
            return acc;
        }, (a, b) -> b)[1];
    }
}
