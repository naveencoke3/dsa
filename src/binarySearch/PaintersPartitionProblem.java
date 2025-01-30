package binarySearch;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
    Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.

Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.

Input 1:

 A = 10
 B = 1
 C = [1, 8, 11, 3]

 Output 1:

 11

 Explanation 1:

 Each block is painted by a painter so, Painter 1 paints block 1, painter 2 paints block 2, painter 3 paints block 3
 and painter 4 paints block 4, time taken = max(1, 8, 11, 3) = 11
 ans = 11 % 10000003

 TC:O(nlogn)
SC:O(1)
 */
public class PaintersPartitionProblem {
    public static void main(String[] args) {
        System.out.println(new PaintersPartitionProblem().partition(List.of(1,8,11,3),2));
    }

    /*
    Since Its MiniMax kind of problem 1st we need to find the range of ans which lies. For this problem it will be lies between max of array to sum of array elements and after finding it start do the partition to attain maximum possibility.
     */
    public int partition(List<Integer> A, int B) {
        int low = A.stream().max(Comparator.naturalOrder()).get();
        int high  = A.stream().reduce(0,Integer::sum);
        int ans = 0;
        while(low<high){
            int mid = low+(high-low)/2;
            if(noOfPainters(A,mid)<=B){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    private int noOfPainters(List<Integer> A, int mid) {
        return A.stream().reduce(new int[]{0,0},(acc,val)->{
            if(acc[0]+val>mid){
                acc[0] = val;
                acc[1]++;
            }else{
                acc[0]+=val;
            }
            return acc;
        },(a,b)->b)[1];
        /*int num = 0; int sum = 0;
        for(int i=1;i<A.size();i++){
            sum+=A.get(i);
            if(sum>mid){
                sum = A.get(i);
                num++;
            }
        }
        return num;*/
    }


}
