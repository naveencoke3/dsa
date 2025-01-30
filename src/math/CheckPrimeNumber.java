package math;

import java.util.stream.IntStream;

public class CheckPrimeNumber {
    public static void main(String[] args) {
        //int noOfFactors = new CheckPrimeNumber().findNoOfFactors(3);
        int noOfFactors = new CheckPrimeNumber().findNoOfFactorsUsingStream(3);
        if(noOfFactors==2){
            System.out.print("Prime");
        }else{
            System.out.print("Not Prime");
        }
    }

    public int findNoOfFactorsUsingStream(int n){
        return IntStream.rangeClosed(1,(int)Math.sqrt(n))
                .filter(i-> n%i==0)
                .reduce(0,(sum,i)->{
                    return n/i==i ? sum+1: sum+2;
                });
    }

    public int findNoOfFactors(int A){
        int count=0;
        for(int i=1;i<=A/i;i++){
            if(A%i==0){
                count++;
                if(i!=A/i){
                    count++;
                }
            }
        }
        return count;
    }
}
