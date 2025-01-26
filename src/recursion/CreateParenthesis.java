package recursion;

public class CreateParenthesis {

    /*
    Create valid parenthesis based on n
    if n = 3 then need to ()()(),(())(),()(()),((()))
     */
    public static void main(String[] args) {
        new CreateParenthesis().buildParenthesis(3,0,0,"");
    }

    public void buildParenthesis(int n, int opening, int closing, String str){
        if(closing == n){
            System.out.println(str);
            return;
        }
        if(opening<n){
            buildParenthesis(n,opening+1,closing,str+"(");
        }
        if(opening>closing){
            buildParenthesis(n,opening,closing+1,str+")");
        }
    }
}
