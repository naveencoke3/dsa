package sorting;

import java.util.ArrayList;
import java.util.List;

/*
Best TC - O(nlogn)
Worst Tc - O(N^2) //if its already sorted
SC - O(logn)
 */
public class QuickSorting {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(List.of(4,1,8,9,3,8,1,9,4));
        new QuickSorting().quickSort(input,0,input.size()-1);
        System.out.println(input);
    }

    public void quickSort(List<Integer> input, int start,int end){
        if(start<end){
            int pivot = partition(input,start,end);
            quickSort(input, start, pivot-1);
            quickSort(input,pivot+1,end);
        }
    }

    public int partition(List<Integer> input,int start, int end){
        int pivot = input.get(start);
        int left = start+1;
        int right = end;
        while(left<=right){
            if(input.get(left)<=pivot){
                left++;
            } else if (input.get(right)>pivot) {
                right--;
            }else{
                swap(input,left,right);
                left++;
                right--;
            }
        }
        swap(input,start,right);
        return right;
    }

    public void swap(List<Integer> input,int left,int right){
        int temp = input.get(left);
        input.set(left,input.get(right));
        input.set(right,temp);
    }
}
