class Solution {
    public int fib(int n) {
        if (n==0) return 0;
        int prev0 = 0; int prev1 = 1;
        int cur = 0;
        for (int i = 2; i <=  n ;i++ ){

            cur = prev0 + prev1;
            prev0 = prev1;
            prev1 = cur;

        }
        return prev1;
    }
}