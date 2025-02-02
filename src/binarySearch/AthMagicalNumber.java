package binarySearch;

/*
You are given three positive integers, A, B, and C.

Any positive integer is magical if divisible by either B or C.

Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Note: Ensure to prevent integer overflow while calculating.

Input 1:

 A = 8
 B = 2
 C = 3

 Output 1:

 12

 Explanation:
 First four magical numbers are 2, 3, 4, 6, 8, 9, 10, 12.so the 4th magical number is 12.
 */
public class AthMagicalNumber {
    public static void main(String[] args) {
        System.out.println(new AthMagicalNumber().partition(8,2,3));
    }
    /*
        First we need to find number of magical numbers available before that particular number. So we can consider to find number of magical numbers available up to x

        To find number of numbers which is divisible by B will be find by x/B;
        To find number of numbers which is divisible by C will be find by x/C;
        To find number of numbers which is divisible by B,C will be find by finding lcm for B and C. To find LCM(B,C) = B*C/GCD(B,C);

        And the range we need to find right for that the range will be between A*min(B,C)
         */
    public int partition(int A,int B,int C) {
        int lcm  = findLCM(B,C);
        int low = 1, high = A*Math.min(B,C), ans = 0;
        while(low<high){
            int mid = low+(high-low)/2;
            if((mid/B+mid/C)-mid/lcm < A){
                low = mid+1;
            }else{
                ans = mid;
                high=mid-1;
            }
        }
        return ans;
    }

    public int findLCM(int B,int C){
        return B*C/gcd(B,C);
    }

    public int gcd(int B,int C){
        if(C==0){
            return B;
        }
        return gcd(C,B%C);
    }
}
