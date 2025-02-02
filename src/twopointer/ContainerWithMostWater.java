package twopointer;

import sorting.ComparatorExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/*
Given N non-negative integers A[0], A[1], ..., A[N-1] , where each represents a point at coordinate (i, A[i]).

N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).

Find two lines, which together with x-axis forms a container, such that the container contains the most water. You need to return this maximum area.

Note: You may not slant the container. It is guaranteed that the answer will fit in integer limits.

 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(4,2,10,6,8,2,6,2));
        new ContainerWithMostWater().findMostWaterUsingStream(list);
    }

    public void findMostWaterUsingStream(List<Integer> list){
        AtomicInteger i = new AtomicInteger(0);
        AtomicInteger j = new AtomicInteger(list.size()-1);
        int res=IntStream.generate(()->0).takeWhile(x->i.get()<j.get()).reduce(0,(sum,val)->{
                    sum = Math.max(sum,Math.min(list.get(i.get()),list.get(j.get()))*(j.get()-i.get()));
                    if(list.get(i.get())< list.get(j.get())){
                        i.incrementAndGet();
                    } else if (list.get(j.get())< list.get(i.get())) {
                        j.decrementAndGet();
                    }else{
                        i.incrementAndGet();
                        j.decrementAndGet();
                    }
                    return sum;
        });
        System.out.println(res);
    }

    public void findMostWater(List<Integer> list){
        int i=0,j=list.size()-1,sum=0;
        while(i<j){
            sum = Math.max(sum,Math.min(list.get(i),list.get(j))*(j-i));
            if(list.get(i)< list.get(j)){
                i++;
            } else if (list.get(j)< list.get(i)) {
                j--;
            }else{
                i++;
                j--;
            }
        }
        System.out.println(sum);
    }

}
