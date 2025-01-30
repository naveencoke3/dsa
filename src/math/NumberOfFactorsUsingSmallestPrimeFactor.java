package math;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class NumberOfFactorsUsingSmallestPrimeFactor {
    public static void main(String[] args) {
        new NumberOfFactorsUsingSmallestPrimeFactor().countFactors(360);
    }

    /*issue with passing s from outside.. since its passed inside its creating unbreakable loop*/
    public void countFactorsUsingStream(int n){
        ArrayList<Integer> spf = new NumberOfFactorsUsingSmallestPrimeFactor().smallestPrimeFactor(n);
        int ans = IntStream.iterate(n, num->num>1,num->{
            int s = spf.get(n);
            while(num%s==0){
                num = num/s;
            }
            return num;
        }).map(num->{
            int s = spf.get(n);
            int count=0;
            while(num%s==0){
                num = num/s;
                count+=1;
            }
            return count;
        }).reduce(1,(a,b)->a*b);
        System.out.print(ans);
    }

    public void countFactors(int n){
        ArrayList<Integer> spf = new NumberOfFactorsUsingSmallestPrimeFactor().smallestPrimeFactor(n);
        int ans =1;
        int s = spf.get(n);
        while(n>1){
            int count = 0;
            while(n%s==0){
                n = n/s;
                count+=1;
            }
            ans*=(count+1);
            s = spf.get(n);
        }
        System.out.print(ans);
    }

    public ArrayList<Integer> smallestPrimeFactor(int n){
        ArrayList<Integer> isPrime = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            isPrime.add(i);
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(isPrime.get(i)==i) {
                for(int j=i*i;j<=n;j+=i){
                    if(j==isPrime.get(j))
                        isPrime.set(j,i);
                }
            }
        }
        return isPrime;
    }
}
