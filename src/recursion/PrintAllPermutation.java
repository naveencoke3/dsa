package recursion;

public class PrintAllPermutation {
    public static void main(String[] args) {
        String str = "abc";
        new PrintAllPermutation().printPermutation(str,0,str.length(),"");
    }

    public void printPermutation(String str,  int idx, int n, String perm){
        if(perm.length()== n){
            System.out.println(perm);
            return;
        }
        for(int i=0;i<str.length();i++){
            if(!perm.contains(String.valueOf(str.charAt(i))))
                printPermutation(str,idx+1,n,perm+str.charAt(i));
        }
    }
}
