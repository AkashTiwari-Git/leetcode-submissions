class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        return tabulation(n, dp);
    }

    private static int tabulation(int n, int[] dp){
        if (n == 0) return 0;
        if (n <= 2) return 1;

        int prev0 = 0; int prev2 = 1; int prev1 = 1;
        int cur = 0;
        for (int i = 3; i <=  n ;i++ ){

            cur = prev0 + prev1 + prev2;
            prev0 = prev1;
            prev1 = prev2;
            prev2 = cur;

        }
        return prev2;
    }

    private static int helper(int n, int[] dp){
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (dp[n] != 0) return dp[n];
        int sum = helper(n-1, dp) + helper(n-2, dp) + helper(n-3, dp);
        dp[n] = sum;
        return sum; 
    }
}