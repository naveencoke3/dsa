import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContinuousSumQuery {

/*
Problem Description

There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars sitting next to each other.

Given the amount P donated by each devotee to the beggars ranging from L to R index, where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, given by the 2D array B

Example Input

Input 1:-
A = 5
B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]


Example Output

Output 1:-
10 55 45 25 25


Example Explanation

Explanation 1:-
First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]
 */
    public static void main(String[] args) {
        int A = 5;
        List<List<Integer>> B = List.of(
                List.of(1,2,10),
                List.of(2,3,20),
                List.of(2,5,25));
        //System.out.println(new ContinuousSumQuery().findContinousSumQuery(A, B));
        System.out.println(new ContinuousSumQuery().findContinousSumQueryUsingStream(A, B));

    }

    public List<Integer> findContinousSumQueryUsingStream(int A, List<List<Integer>> B){
        List<Integer> result = Stream.generate(()->0).limit(A).collect(Collectors.toList());
        B.forEach(list ->{
            result.set(list.get(0)-1, result.get(list.get(0)-1)+list.get(2));
            if(list.get(1)<A)
                result.set(list.get(1), result.get(list.get(1))-list.get(2));
        });
        for(int i=1;i<result.size();i++){
            result.set(i, result.get(i)+result.get(i-1));
        }
        return result;
    }

    public List<Integer> findContinousSumQuery(int A, List<List<Integer>> B){
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<A;i++){
            result.add(0);
        }
        for(List<Integer> list : B){
            result.set(list.get(0)-1, result.get(list.get(0)-1)+list.get(2));
            if(list.get(1)<A)
                result.set(list.get(1), result.get(list.get(1))-list.get(2));
        }
        for(int i=1;i<result.size();i++){
            result.set(i, result.get(i)+result.get(i-1));
        }
        return result;
    }
}
