package tree.binarysearchtree;

import tree.Node;

import java.util.List;

public class ConstructBST {
    public static void main(String[] args) {
        Node tree = new ConstructBST().construct(List.of(1,3,4,6,7,8,10,13,14),0,8);
        System.out.println(tree);
    }

    public Node construct(List<Integer> arr, int start, int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        Node root = new Node(arr.get(mid));
        root.left = construct(arr,start,mid-1);
        root.right = construct(arr, mid+1, end);
        return root;
    }
}
