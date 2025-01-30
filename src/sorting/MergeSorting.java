package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeSorting {

    /*
    TC: O(nlogn)
    SC: O(N)
     */
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(List.of(4, 1, 1, 0, 0, 0, 2, 1, 3));
        new MergeSorting().mergeSorting(input, 0,input.size()-1);
        System.out.println(input);
    }

    public void mergeSorting(List<Integer> input, int l, int r){
        if(l<r){
            int mid = (l+r)/2;
            mergeSorting(input,l,mid);
            mergeSorting(input,mid+1,r);
            merge(input,l,r,mid);
        }
    }

    public void merge(List<Integer> input, int l,int r,int mid){
        int leftSize = mid-l+1;
        int rightSize = r-mid;
        ArrayList<Integer> leftArray = IntStream.range(0,leftSize).mapToObj(i-> input.get(l+i)).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> rightArray = IntStream.range(0,rightSize).mapToObj(i-> input.get(mid + 1 + i)).collect(Collectors.toCollection(ArrayList::new));
        int i=0;int j=0;int k=l;
        while(i<leftSize && j<rightSize){
            if (leftArray.get(i)<rightArray.get(j)){
                input.set(k,leftArray.get(i));
                i++;
            }else{
                input.set(k,rightArray.get(j));
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            input.set(k,leftArray.get(i));
            i++;
            k++;
        }

        while (j < rightSize) {
            input.set(k,rightArray.get(j));
            j++;
            k++;
        }
    }
}
