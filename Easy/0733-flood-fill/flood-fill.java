class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        int[][] ans = image;
        // start with the starting node 
        int[] rows = {-1,0,+1,0};
        int[] cols = {0,+1,0,-1};
        dfs(image, ans, sr, sc, color, initialColor, rows, cols);
        return ans;
    }
    private static void dfs(int[][] image, int[][] ans, int r, int c , int color, int initialColor, int[] rows, int[] cols){
        int m = image.length;
        int n = image[0].length;
        ans[r][c] = color;
        for (int i = 0; i < 4; i ++){
            int nrow = r + rows[i];
            int ncol = c + cols[i];
            if (nrow >= 0 && ncol >=0 && nrow < m && ncol < n && image[nrow][ncol] == initialColor && ans[nrow][ncol]!=color){
                dfs(image, ans, nrow, ncol, color, initialColor, rows, cols);
            }
        }
    }
}