package math;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintAllPrimes {

    public static void main(String[] args) {
        //new PrintAllPrimes().printAllPrimeUnOptimized(10);
        //new PrintAllPrimes().printAllPrimeOptimized(10);
        new PrintAllPrimes().printAllPrimeOptimizedUsingStream(10);
    }

    /*
    Sieve of Eratosthenes approach
    1. Assume all no of 2 to n are prime numbers
    2. start with the first prime number and mark all its multiples as non prime number.
    3. Move to the next unmarked number and consider it as prime and mark all its multiples as non prime
    4. repeat the process till the end. finally print all the unmarked numbers as prime.

    T.C is O(n(log(log n)))
     */
    public void printAllPrimeOptimized(int n){
        ArrayList<Boolean> isPrime = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            isPrime.add(true);
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(isPrime.get(i)){
                for(int j=i*i;j<=n;j+=i){
                    isPrime.set(j,false);
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(isPrime.get(i)){
                System.out.println(i);
            }
        }
    }

    public void printAllPrimeOptimizedUsingStream(int n){
        ArrayList<Boolean> isPrime = IntStream.rangeClosed(0,n).mapToObj(i->true).collect(Collectors.toCollection(ArrayList::new));
        //ArrayList<Boolean> isPrime = Stream.generate(()->true).limit(n+1).collect(Collectors.toCollection(ArrayList::new));//Alternate way.
        IntStream.rangeClosed(2, (int) Math.sqrt(n))
                .filter(isPrime::get)
                .forEach(i-> IntStream.iterate(i*i,j -> j<= n, j-> j+i)
                        .forEach(j->isPrime.set(j,false)));
        IntStream.rangeClosed(2,n).filter(isPrime::get).forEach(System.out::println);
    }

    //n√n time complexity code
    public void printAllPrimeUnOptimized(int n){
        for(int i=2;i<n;i++){
            boolean isPrime = true;
            for(int j=2;j<=Math.sqrt(i);j++){//Since we started from 2 the factor of 1 and itself is ruled out. so if it gets any factor then its not prime.
                if(i%j==0){
                    isPrime=false;
                    break;
                }
            }
            if(isPrime)
                System.out.print(i+ " ");
        }
    }
}
