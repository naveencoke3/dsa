package twopointer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class FindPair {
    //find all pair from a sorted array whose sum is equal to k.
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6,8)); int k=10;
        //new FindPair().findPair(list,k);
        new FindPair().findPairUsingStream(list,k);
    }

    public void findPairUsingStream(List<Integer> list,int k){
        AtomicInteger i = new AtomicInteger(0);
        AtomicInteger j = new AtomicInteger(list.size()-1);
        int count = IntStream.generate(()->0).takeWhile(x->i.get()<j.get())
                .map(x->{
                    int sum = list.get(i.get())+ list.get(j.get());
                    if(sum==k){
                        i.incrementAndGet();
                        j.decrementAndGet();
                        return 1;
                    }else if(sum>k){
                        j.decrementAndGet();
                    }else {
                        i.incrementAndGet();
                    }
                    return 0;
                }).sum();
        System.out.println(count);
    }

    public void findPair(List<Integer> list,int k){
        int i=0,j=list.size()-1,count=0;
        while (i<j){
            if(list.get(i)+ list.get(j)==k){
                count++;
                i++;
                j--;
            }else if(list.get(i)+ list.get(j)>k){
                j--;
            }else {
                i++;
            }
        }
        System.out.println(count);
    }
}
