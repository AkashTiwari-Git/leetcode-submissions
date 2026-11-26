class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int t = k*2;
        int[][] dp= new int[n][t+1];
        for (int[] r : dp){
            Arrays.fill(r, -1);
        }
        return f(0, t, n , prices, dp);
    }

    private static int f(int i , int t, int n, int[] prices, int[][] dp){
        if ( t==0 || i==n ) return 0;
        if (dp[i][t] != -1) return dp[i][t];
        int profit = 0;
        if (t % 2 == 0){
            profit  = Math.max(-prices[i] + f(i+1, t-1, n, prices, dp), f(i+1, t, n, prices, dp));
        } else {
             profit  = Math.max(prices[i] + f(i+1,t-1, n, prices, dp), f(i+1,t, n, prices, dp));
        }
        return dp[i][t] = profit;
    }
}