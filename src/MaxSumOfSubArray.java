import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxSumOfSubArray {

    public Integer findMaxSumOfSubArray(List<Integer> list){
        int max = Integer.MIN_VALUE, currentMax = 0;
        for(int i=0;i<list.size();i++){
            currentMax+=list.get(i);
            if(max<currentMax){
                max = currentMax;
            }
            if(currentMax<0){
                currentMax = 0;
            }
        }
        return max;
    }

    public Integer findMaxSumOfSubArrayUsingStream(List<Integer> list){
        AtomicInteger currentMax = new AtomicInteger(0);
        return list.stream().reduce(Integer.MIN_VALUE,(max,value)->{
            int current = currentMax.addAndGet(value);
            currentMax.set(Math.max(0,current));
            return Math.max(current,max);
        });
    }

    /**
     * Find the maximum sum of contiguous non-empty subarray within an array A of length N.
     * Input : A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
     * Output: 6.
     * Explanation: The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
     * -------------------------
     * Requires Kadane's Algorithm
     * */
    public static void main(String[] args) {
        List<Integer> list = List.of(-2, 1, -3, 4, -1, 2, 1, -5, 4);
        //System.out.print(new MaxSumOfSubArray().findMaxSumOfSubArray(list));
        System.out.print(new MaxSumOfSubArray().findMaxSumOfSubArrayUsingStream(list));
    }
}
