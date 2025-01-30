package math;

import java.util.ArrayList;

public class SmallestPrimeFactor {
    public static void main(String[] args) {
        new SmallestPrimeFactor().printSmallestPrimeFactor(10);
    }
    /*similar to Sieve of Eratosthenes approach */
     public void printSmallestPrimeFactor(int n){
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
         for(int i=2;i<=n;i++){
             System.out.println(isPrime.get(i));
         }
     }
}
