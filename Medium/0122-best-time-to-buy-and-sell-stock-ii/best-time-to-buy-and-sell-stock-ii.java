class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] r: dp){
            Arrays.fill(r, -1);
        }
        return f(0, 1, prices.length, prices, dp);
    }

    private static int f(int i , int buy, int n,  int[] prices, int[][] dp){
        if (i==n) return 0;
        int profit = 0;
        if (dp[i][buy] != -1) return dp[i][buy];
        if (buy==1) {
            profit = Math.max(-prices[i] + f(i+1, 0, n, prices, dp), f(i+1, 1, n, prices, dp));
        } else {
            profit = Math.max(prices[i] + f(i+1, 1, n, prices, dp), f(i+1, 0, n, prices, dp));
        }
        return dp[i][buy] = profit;
    }
}