package tree;

import java.util.List;
/*
Construct tree based inorder and postOrderTraversal List
 */
public class ConstructTree {

    public static void main(String[] args) {
        Node node = new ConstructTree().buildTree(List.of(4,2,7,5,1,3,6), List.of(4,7,5,2,6,3,1));
        System.out.println(node);
    }

    public Node buildTree(List<Integer> inorderList, List<Integer> postOrderList) {
        if(postOrderList.isEmpty()){
            return null;
        }
        int root = postOrderList.get(postOrderList.size() - 1);
        int root_Index = inorderList.indexOf(root);
        Node node = new Node(root);
        node.left = buildTree(inorderList.subList(0, root_Index), postOrderList.subList(0, root_Index));
        node.right = buildTree(inorderList.subList(root_Index+1, inorderList.size()), postOrderList.subList(root_Index, postOrderList.size() - 1));
        return node;
    }
}