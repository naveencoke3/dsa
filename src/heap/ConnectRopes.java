package heap;

import java.util.ArrayList;
import java.util.List;

/*
You are given an array A of integers that represent the lengths of ropes.
You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
Find and return the minimum cost to connect these ropes into one rope.
Input 1:
 A = [1, 2, 3, 4, 5]
 Output 1:
 33
 Explanation 1:
 Given array A = [1, 2, 3, 4, 5].
 Connect the ropes in the following manner:
 1 + 2 = 3
 3 + 3 = 6
 4 + 5 = 9
 6 + 9 = 15
 So, total cost  to connect the ropes into one is 3 + 6 + 9 + 15 = 33.
 */
public class ConnectRopes {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        List<Integer> input1 = new ArrayList<>(List.of(6,19,9,14,17,16,7,2,14,4,3));
        int sum=0;
        for(int i=0;i<input1.size();i++){
            new ConnectRopes().insert(input,input1.get(i));
        }
        while(input.size()>1){
            int result = new ConnectRopes().extractMin(input);
            int result1 = new ConnectRopes().extractMin(input);
            sum+=result1+result;
            new ConnectRopes().insert(input,result1+result);;
            //new ConnectRopes().heapify(input,resultArray);
        }
        System.out.println(sum);
    }

    public void insert(List<Integer> input, int data){
        input.add(data);
        int i=input.size()-1;
        while(i>0){
            int parentIndex = (i-1)/2;
            if(input.get(parentIndex)>input.get(i)){
                swap(input,parentIndex,i);
                i=parentIndex;
            }else
                break;
        }
    }



    public void heapify(List<Integer> input, int i){
        int x;
        while((2*i)+1<input.size()){
            if((2*i)+2<input.size()){
                x = Math.min(input.get(i),Math.min(input.get((2*i)+1),input.get((2*i)+2)));
            }else{
                x = Math.min(input.get(i),input.get((2*i)+1));
            }
            if(x==input.get(i)){
               break;
            }
            if(x==input.get((2*i)+1)){
                swap(input,i,(2*i)+1);
                i = (2*i)+1;
            }else if(x==input.get((2*i)+2)){
                swap(input,i,(2*i)+2);
                i = (2*i)+2;
            }
        }
    }

    public int extractMin(List<Integer> input){
        heapify(input,0);
        swap(input,0, input.size()-1);
        int result = input.getLast();
        input.remove(input.size()-1);
        heapify(input,0);
        return result;
    }

    public void swap(List<Integer> input, int i, int j){
        int temp = input.get(i);
        input.set(i,input.get(j));
        input.set(j,temp);
    }
}
