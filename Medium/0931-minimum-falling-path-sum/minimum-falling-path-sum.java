class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < matrix[0].length; i++){
            ans = Math.min(ans, helper(0, i, matrix, dp));
        }
        return ans;
    }

    private static int helper (int n,  int i, int[][] matrix, int[][] dp){
        if (i < 0 || i >= matrix.length) return Integer.MAX_VALUE / 2;
        if (n == matrix.length-1) return matrix[n][i];
        if (dp[n][i] != Integer.MAX_VALUE) return dp[n][i];
        int a = helper(n+1, i - 1, matrix, dp);
        int b = helper(n+1, i, matrix, dp);
        int c = helper(n+1, i + 1, matrix, dp);
        dp[n][i] = matrix[n][i] + Math.min(a, Math.min(b, c));
        return dp[n][i];
    }
}