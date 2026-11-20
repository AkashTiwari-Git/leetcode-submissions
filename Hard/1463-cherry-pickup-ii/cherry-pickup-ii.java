class Solution {
    public int cherryPickup(int[][] grid) {
        int m =  grid.length; int n = grid[0].length;
        double[][][] dp = new double[m][n][n];
        for (double[][] mat : dp){
            for (double[] row : mat){
                Arrays.fill(row, -1);
            }
        }
        
        return (int)helper(0, grid[0].length - 1, 0, m, n, grid, dp);
    }
    
    private static double helper(int j1, int j2, int i, int r, int c, int[][] grid, double[][][] dp){
        if (j1 < 0 || j1 >= c || j2 < 0 || j2 >= c) return -1e8;
        if (i == r - 1){
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
        double max = -1e8;
        for (int d1 = -1; d1 <= +1; d1++){
            for (int d2 = -1; d2 <= +1; d2++){
                int value = 0;
                if (j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                value += helper(j1+d1, j2+d2, i+1, r, c, grid, dp);
                max = Math.max(max, value);
            }
        }
        dp[i][j1][j2] = max;
        return dp[i][j1][j2];
    }
}