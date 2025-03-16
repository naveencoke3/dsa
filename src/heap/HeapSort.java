package heap;

import java.util.ArrayList;
import java.util.List;

public class HeapSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(14,13,10,7,6,8,5,2,1,3));
        new HeapSort().sort(list);
    }

    private void sort(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list1 = buildHeap(list);
        while (!list1.isEmpty()){
            result.add(new ConnectRopes().extractMin(list1));
        }
        System.out.println(result);
    }

    public List<Integer> buildHeap(List<Integer> list){
        List<Integer> heap = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            new ConnectRopes().insert(heap, list.get(i));
        }
        return heap;
    }
}
