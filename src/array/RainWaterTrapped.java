package array;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.stream.IntStream;

public class RainWaterTrapped {
    /*
    Imagine a histogram where the bars' heights are given by the array A. Each bar is of uniform width, which is 1 unit. When it rains, water will accumulate in the valleys between the bars.

    Your task is to calculate the total amount of water that can be trapped in these valleys.

    The Array A = [5, 4, 1, 4, 3, 2, 7] is visualized as below.
    The total amount of rain water trapped in A is 11

     */
    public static void main(String[] args) {
        List<Integer> list = List.of(5, 4, 1, 4, 3, 2, 7);
        //System.out.print(new RainWaterTrapped().totalTrappedWater(list));
        System.out.print(new RainWaterTrapped().totalTrappedWaterUsingStream(list));
    }

    public int totalTrappedWaterUsingStream(List<Integer> list){
        int size = list.size();
        AtomicIntegerArray leftMax = new AtomicIntegerArray(size);
        AtomicIntegerArray rightMax = new AtomicIntegerArray(size);
        leftMax.set(0,list.getFirst());
        rightMax.set(list.size()-1,list.getLast());

        IntStream.range(1,size).forEach(i->{
            leftMax.set(i, Math.max(list.get(i),leftMax.get(i-1)));
        });
        IntStream.range(0,size-1).mapToObj(i->size-i-2)
                .forEach(i ->
                        rightMax.set(i, Math.max(list.get(i), rightMax.get(i + 1)))
                );
        return IntStream.range(0, size)
                .map(i -> Math.min(leftMax.get(i), rightMax.get(i)) - list.get(i))
                .sum();
    }

    public int totalTrappedWater(List<Integer> list){
        List<Integer> leftMax = new ArrayList<>();
        List<Integer> rightMax = new ArrayList<>();
        leftMax.add(list.get(0));
        rightMax.add(0);
        for(int i=1;i<list.size();i++){
            leftMax.add(Math.max(list.get(i),leftMax.get(i-1)));
            rightMax.add(0);
        }
        rightMax.set(list.size()-1,list.get(list.size()-1));
        for(int i=list.size()-2;i>=0;i--){
            rightMax.set(i, Math.max(list.get(i),rightMax.get(i+1)));
        }
        int sum = 0;
        for(int i=0;i<list.size();i++){
            sum+=Math.min(leftMax.get(i),rightMax.get(i)) - list.get(i);
        }
        return sum;
    }
}
