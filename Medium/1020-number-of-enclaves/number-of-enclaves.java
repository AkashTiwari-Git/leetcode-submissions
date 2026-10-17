class Solution {
    public int numEnclaves(int[][] grid) {
int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int ans = 0;
        // detect any 1
        // first row :
        for (int i = 0; i < m; i++){
            if (grid[0][i] == 1){
                dfs(0, i, grid, vis);
            }
        }
        for (int i = 0; i < m; i++){
            if (grid[n-1][i] == 1){
                dfs(n-1, i, grid, vis);
            }
        }

        // for cols
        for (int i = 0; i < n; i++){
            if (grid[i][0] == 1){
                dfs(i, 0, grid, vis);
            }
        }
        for (int i = 0; i < n; i++){
            if (grid[i][m-1] == 1){
                dfs(i, m-1, grid, vis);
            }
        }

        // by now every one on the corners of the boundary must be marked as visited so
        for (int i = 0; i < n; i++){
            for (int j = 0; j< m; j++){
                if (!vis[i][j] && grid[i][j] == 1){
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void dfs(int s, int e, int[][] grid, boolean[][] vis) {
        vis[s][e] = true;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        for (int i = 0; i < 4; i++){
            int nrow = s + delrow[i];
            int ncol = e + delcol[i];

            if (nrow > 0 && ncol > 0 && nrow < grid.length && ncol < grid[0].length&& !vis[nrow][ncol] && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, grid, vis);
            }
        }
    }
}