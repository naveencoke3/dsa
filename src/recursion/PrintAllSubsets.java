package recursion;

import java.util.LinkedList;
import java.util.List;

public class PrintAllSubsets {
    public static void main(String[] args) {
        List<Integer> list = List.of(10,20,30);
        new PrintAllSubsets().printSubset(list,0,new LinkedList<>());
    }

    public void printSubset(List<Integer> input, int idx, List<Integer> list){
        if(idx==input.size()){
            System.out.println(list);
            return;
        }
        list.add(input.get(idx));
        printSubset(input, idx+1, list);
        list.removeLast();
        printSubset(input, idx+1, list);
    }
}
