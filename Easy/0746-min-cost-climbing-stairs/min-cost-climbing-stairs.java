class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[][] dp = new int[2][cost.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return Math.min(helper(0, cost.length, cost, dp), helper(1, cost.length, cost, dp));
    }

    private static int helper(int start, int n, int[] cost, int[][] dp){
        if (n == start) return cost[n];

        if (n < start) return Integer.MAX_VALUE / 2;

        if (n == cost.length){
            return Math.min(helper(start, n-1, cost, dp), helper(start, n-2, cost, dp));
        }

        if (dp[start][n] != -1) return dp[start][n];

        dp[start][n] = cost[n] + Math.min(helper(start, n-1, cost, dp), helper(start, n-2, cost, dp));
        return dp[start][n];
    }
}