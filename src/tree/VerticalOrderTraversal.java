package tree;

import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.right = new Node(9);
        root.right.left.left = new Node(8);
        new VerticalOrderTraversal().verticalOrderTraversal(root);
        System.out.println();
        System.out.println("============Top view ==============");
        new VerticalOrderTraversal().topOrderView(root);
    }

    private void topOrderView(Node root) {
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        queue.add(new Pair(0,root));
        int min=0,max =0;
        while(!queue.isEmpty()){
            Pair x= queue.poll();
            Integer level = x.level;
            Node curr = x.node;
            if(map.isEmpty() || !map.containsKey(level)){
                map.put(level,new ArrayList<>());
                List<Integer> list = map.get(level);
                list.add(curr.data);
                map.put(level,list);
            }
            if(curr.left!=null){
                queue.add(new Pair(level-1,curr.left));
            }
            if(curr.right!=null){
                queue.add(new Pair(level+1,curr.right));
            }
            min = Math.min(level,min);
            max = Math.max(level,max);
        }
        while (min<=max){
            System.out.print(map.get(min));
            min++;
        }
    }

    public class Pair{
        Integer level;
        Node node;
        public Pair(Integer level,Node node){
            this.level=level;
            this.node = node;
        }
    }

    public void verticalOrderTraversal(Node root){
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        queue.add(new Pair(0,root));
        int min=0,max =0;
        while(!queue.isEmpty()){
            Pair x= queue.poll();
            Integer level = x.level;
            Node curr = x.node;
            if(map.isEmpty() || !map.containsKey(level)){
                map.put(level,new ArrayList<>());
            }
            List<Integer> list = map.get(level);
            list.add(curr.data);
            map.put(level,list);
            if(curr.left!=null){
                queue.add(new Pair(level-1,curr.left));
            }
            if(curr.right!=null){
                queue.add(new Pair(level+1,curr.right));
            }
            min = Math.min(level,min);
            max = Math.max(level,max);
        }
        while (min<=max){
            System.out.print(map.get(min));
            min++;
        }
    }
}
