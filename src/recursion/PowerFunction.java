package recursion;

public class PowerFunction {
    public static void main(String[] args) {
        int a=2;
        int n=18;
        System.out.print(new PowerFunction().pow(a,n));
    }

    public int pow(int a, int n){
        if(n==0){
            return 1;
        }
        int powValue = pow(a,n/2);
        if(n%2==0){
            return powValue*powValue;
        }else{
            return powValue*powValue*a;
        }
    }
}
