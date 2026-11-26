class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for (int[][] g: dp){
            for (int[] r: g){
                Arrays.fill(r, -1);
            }
        }
        return f(0, 1, 2, n, prices, dp);
    }

    private static int f(int i, int buy, int cap, int n, int[] prices, int[][][] dp){
        if (i==n || cap == 0) return 0;
        if (dp[i][buy][cap]!=-1) return dp[i][buy][cap];
        int profit = 0;
        if (buy == 1){
            profit = Math.max(-prices[i] + f(i+1, 0, cap, n, prices, dp), f(i+1, 1, cap, n, prices, dp));
        } else {
            profit = Math.max(prices[i] + f(i+1, 1, cap-1, n, prices, dp), f(i+1, 0, cap, n, prices, dp));
        }
        return dp[i][buy][cap] = profit;
    }
}