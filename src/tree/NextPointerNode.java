package tree;

public class NextPointerNode {
    public int data;
    public NextPointerNode left;
    public NextPointerNode right;
    public NextPointerNode next;
    public NextPointerNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}
