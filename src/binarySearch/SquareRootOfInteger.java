package binarySearch;

/*
TC:O(logn)
SC:O(1)
 */
public class SquareRootOfInteger {
    public static void main(String[] args) {
        System.out.println(new SquareRootOfInteger().findSquareRootOfInteger(11));
    }

    public int findSquareRootOfInteger(int n) {
        int low = 1, high = n;
        int ans = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid * mid == n) {
                return n;
            } else if (mid * mid < n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
