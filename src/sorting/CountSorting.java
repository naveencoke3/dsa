package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.

This can be used only when range between the input array is less since we will be creating array with size of the range.

TimeComplexity : O(N)
SpaceComplexity: O(N)
 */
public class CountSorting {

    public static void main(String[] args) {
        new CountSorting().countSorting(List.of(4, 1, 1, 0, 0, 0, 2, 1, 3));
    }

    public void countSorting(List<Integer> input) {
        int max = input.stream().max(Comparator.naturalOrder()).get();
        int min = input.stream().min(Comparator.naturalOrder()).get();
        int range = max - min + 1;
        List<Integer> sortedArray = Stream.generate(() -> 0).limit(range).collect(Collectors.toCollection(ArrayList::new));
        for (int i = 0; i < input.size(); i++) {
            sortedArray.set((input.get(i) - min), sortedArray.get(input.get(i) - min) + 1);
        }
        for (int i = 0; i < sortedArray.size(); i++) {
            if (sortedArray.get(i) > 0) {
                for (int j = 0; j < sortedArray.get(i); j++) {
                    System.out.printf(" " + (i + min));
                }
            }
        }
    }
}
