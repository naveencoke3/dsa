package array;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class MergeSortedIntervals {
    /*
    You have a set of non-overlapping intervals. You are given a new interval [start, end], insert this new interval into the set of intervals (merge if necessary).

    You may assume that the intervals were initially sorted according to their start times.

    Input: Given intervals [1, 3], [6, 9] insert and merge [2, 5] .

    Output: [ [1, 5], [6, 9] ]
     */
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>(List.of(new ArrayList<>(List.of(1,3)), new ArrayList<>(List.of(6,9))));
        ArrayList<Integer> newInterval = new ArrayList<>(List.of(2,5));
        //System.out.print(new MergeSortedIntervals().mergeInterval(input,newInterval));
        System.out.print(new MergeSortedIntervals().mergeIntervalUsingStream(input,newInterval));
    }

    public List<List<Integer>> mergeIntervalUsingStream(ArrayList<ArrayList<Integer>> input, ArrayList<Integer> newInterval){
        final List<List<Integer>> result = new ArrayList<>();
        final List<Integer> mutableInterval = new ArrayList<>(newInterval);
        input.stream().reduce(result ,(res,interval)->{
            if(interval.get(1) < mutableInterval.get(0)){
                res.add(interval);
            } else if (mutableInterval.get(1)<interval.get(0)) {
                res.add(new ArrayList<>(mutableInterval));
                mutableInterval.set(0, interval.get(0));
                mutableInterval.set(1, interval.get(1));
            }else{
                mutableInterval.set(0,Math.min(interval.get(0), mutableInterval.get(0)));
                mutableInterval.set(1,Math.max(interval.get(1), mutableInterval.get(1)));
            }
            return res;
        },(res1, res2) -> {
                    res1.addAll(res2);
                    return res1;
                });
        result.add(new ArrayList<>(mutableInterval));
        return result;
    }

    public List<List<Integer>> mergeInterval(ArrayList<ArrayList<Integer>> input, ArrayList<Integer> newInterval){
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> list:input){
            if(list.get(1) < newInterval.get(0)){
                res.add(list);
            }else if(newInterval.get(1) < list.get(0)){
                res.add(newInterval);
                newInterval = new ArrayList<>(list);
            }else{
                newInterval.set(0,Math.min(list.get(0), newInterval.get(0)));
                newInterval.set(1,Math.max(list.get(1), newInterval.get(1)));
            }
        }
        res.add(newInterval);
        return res;
    }
}
