package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ComparatorExample {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(List.of(9,3,10,6,4));
        System.out.println(input.stream().sorted(Comparator.comparing(ComparatorExample::countFactor).thenComparing(n->n)).toList());

    }

    public static int countFactor(int A){
        return IntStream.rangeClosed(1, (int) Math.sqrt(A)).filter(i->A%i==0).map(i-> A/i!=i?2:1).sum();
    }
}
