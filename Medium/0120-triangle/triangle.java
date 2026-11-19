class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int ans = Integer.MAX_VALUE;
        int m = triangle.size();
        int n = triangle.get(triangle.size()-1).size();
        int[][] dp = new int[m][n];
        for (int[] row : dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, helper(triangle.size() - 1, i , triangle, dp));
        }
        return ans;
    }

    private static int helper(int n, int i,List<List<Integer>> triangle, int[][] dp){
        if (i < 0 || i >= triangle.get(n).size()) return Integer.MAX_VALUE / 2;
        if (n == 0) return triangle.get(0).get(0);
        if (dp[i][n] != Integer.MAX_VALUE) return dp[i][n];
        dp[i][n] = triangle.get(n).get(i) + Math.min (helper(n-1, i-1, triangle, dp), helper(n-1, i, triangle, dp));
        return dp[i][n];

    }
}