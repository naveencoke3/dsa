package binarySearch;

import java.util.ArrayList;
import java.util.List;

/*
There are two sorted arrays A and B of sizes N and M respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

NOTE:

The overall run time complexity should be O(log(m+n)).
IF the number of elements in the merged array is even,
then the median is the average of (n/2)th and (n/2+1)th element.
For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.

Input 1:

 A = [1, 4, 5]
 B = [2, 3]

Output 1:
 3.0

 Explanation 1:
 The median of both the sorted arrays will be 3.0.
 */
public class MedianOfArray {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(List.of(1,4,5,6,7,9));
        List<Integer> B = new ArrayList<>(List.of(8,8,10,11));
        //1,4,5,6,7,8,8,9,10,11
        System.out.println(new MedianOfArray().findMedianSortedLists(A, B));
    }

    public double findMedianSortedLists(List<Integer> A, List<Integer> B) {
        if (A.size() > B.size()) {
            return findMedianSortedLists(B, A);
        }

        int N = A.size(), M = B.size();
        int total = N + M;
        int half = (total + 1) / 2; // Left partition size

        int low = 0, high = N;
        while (low <= high) {
            int midA = (low + high) / 2;  // Partition index for A
            int midB = half - midA;  // Partition index for B

            // Identify boundary elements
            int leftA = (midA > 0) ? A.get(midA - 1) : Integer.MIN_VALUE;
            int rightA = (midA < N) ? A.get(midA) : Integer.MAX_VALUE;
            int leftB = (midB > 0) ? B.get(midB - 1) : Integer.MIN_VALUE;
            int rightB = (midB < M) ? B.get(midB) : Integer.MAX_VALUE;

            // Check if partition is valid
            if (leftA <= rightB && leftB <= rightA) {
                // Found correct partition
                if (total % 2 == 1) {
                    return Math.max(leftA, leftB); // Odd case
                }
                return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0; // Even case
            } else if (leftA > rightB) {
                high = midA - 1; // Move left in A
            } else {
                low = midA + 1; // Move right in A
            }
        }
        throw new IllegalArgumentException("Input lists are not sorted properly.");
    }
}
