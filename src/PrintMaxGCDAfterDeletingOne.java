import recursion.PrintAllPermutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class PrintMaxGCDAfterDeletingOne {
    /*
    Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
    input: A = [12, 15, 18]
    output : 6

    Explanation:
         If you delete 12, gcd will be 3.
         If you delete 15, gcd will be 6.
         If you delete 18, gcd will 3.
         Maximum value of gcd is 6.
     */
    public static void main(String[] args) {
        List<Integer> input = List.of(12,15,18);
        //System.out.println(new PrintMaxGCDAfterDeletingOne().findMaxGcdByDeletingOne(input));
        System.out.println(new PrintMaxGCDAfterDeletingOne().findMaxGcdByDeletingOneUsingStream(input));
    }

    public int findMaxGcdByDeletingOneUsingStream(List<Integer> list){
        List<Integer> prefix = IntStream.range(0,list.size()).collect(ArrayList::new,(prefixSum, val)->{
            prefixSum.add(val == 0 ? list.get(val) : gcd(prefixSum.get(val - 1), list.get(val)));
        },ArrayList::addAll);
        List<Integer> suffix = IntStream.range(0,list.size()).mapToObj(i->list.size()-i-1)
                .collect(()-> new ArrayList<>(Collections.nCopies(list.size(), 0)),(suffixSum, val)->{
            suffixSum.set(val,val == list.size()-1 ? list.get(val) : gcd(suffixSum.get(val+1), list.get(val)));
        },ArrayList::addAll);
        return IntStream.range(0,list.size()).reduce(Integer.MIN_VALUE, (max,i)->{
            int p = (i == 0) ? 0 : prefix.get(i - 1);
            int s = (i == list.size() - 1) ? 0 : suffix.get(i + 1);
            return Math.max(max,gcd(p, s));
        });
    }

    public int findMaxGcdByDeletingOne(List<Integer> list){
        ArrayList<Integer> prefix = new ArrayList<>();
        ArrayList<Integer> suffix = new ArrayList<>();
        prefix.add(list.get(0));
        suffix.add(0);
        for(int i=1;i<list.size();i++){
            prefix.add(gcd(prefix.get(i-1),list.get(i)));
            suffix.add(0);
        }
        suffix.set(list.size()-1,list.get(list.size()-1));
        for(int i=list.size()-2,k=1;i>=0;i--,k++){
            suffix.set(i,gcd(suffix.get(i+1),list.get(i)));
        }
        int sum=0;
        int max= Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            int p = i==0?0:prefix.get(i-1);
            int s = i==list.size()-1?0:suffix.get(i+1);
            sum = gcd(p,s);
            max = Math.max(sum,max);
        }
        return max;
    }

    public int gcd(int A,int B){
        if (B == 0) {
            return A;
        }
        return gcd(B,A%B);
    }
}
