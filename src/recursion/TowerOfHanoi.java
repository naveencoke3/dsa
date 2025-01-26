package recursion;

public class TowerOfHanoi {
    /*
    To Achieve it we need to move n-1 blocks to auxiliary block then move the nth block to destination block
    and then move the n-1 blocks from destination block using source block as auxiliary block. Do it recursively to get solution.
     */
    public static void main(String[] args) {
        int n=4;
        new TowerOfHanoi().passTowerToDestination(n,"A","C","B");
    }

    public void passTowerToDestination(int n,String source, String destination, String auxiliary){
        if(n==0){
            return;
        }
        passTowerToDestination(n-1,source,auxiliary,destination);
        System.out.println(source+"->"+destination);
        passTowerToDestination(n-1,auxiliary,destination,source);
    }
}
