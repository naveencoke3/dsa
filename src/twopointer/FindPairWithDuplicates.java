package twopointer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class FindPairWithDuplicates {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(2,3,3,5,5,5,5,7,7,10,10,15)); int k=10;
        new FindPairWithDuplicates().findPairUsingStream(list,k);
    }

    public void findPairUsingStream(List<Integer> list, int k){
        AtomicInteger i = new AtomicInteger(0);
        AtomicInteger j = new AtomicInteger(list.size()-1);
        int count = IntStream.generate(()->0).takeWhile(x->i.get()<j.get())
                .map(m->{
                    int sum = list.get(i.get())+ list.get(j.get());
                    if(sum==k){
                        int c1=0;int c2=0;int x=list.get(i.get()); int y =  list.get(j.get());
                        while (list.get(i.get())==x){
                            c1++;
                            i.incrementAndGet();
                        }
                        while (list.get(j.get())==y){
                            c2++;
                            j.decrementAndGet();
                        }
                        if(x==y){
                            return c1*(c1-1)/2;
                        }else
                            return c1*c2;
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
                int c1=0;int c2=0;int x=list.get(i); int y =  list.get(j);
                while (list.get(i)==x){
                    c1++;
                    i++;
                }
                while (list.get(j)==y){
                    c2++;
                    j--;
                }
                if(x==y){
                    count+= c1*(c1-1)/2;
                }else
                    count+=c1*c2;
            }else if(list.get(i)+ list.get(j)>k){
                j--;
            }else {
                i++;
            }
        }
        System.out.println(count);
    }
}
