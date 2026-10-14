class Solution {
    public void solve(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0,1,0,-1};
        boolean[][] vis = new boolean[n][m];
        for(int j = 0; j< m; j++){
            // first row 
            if (!vis[0][j]&& mat[0][j] == 'O'){
                dfs(0, j, vis, mat, delrow, delcol);
            }
            // last row 
            if (!vis[n-1][j] && mat[n-1][j] == 'O'){
                dfs(n-1, j, vis, mat, delrow, delcol);
            }
        }

        for(int i = 0; i< n; i++){
            // first col 
            if (!vis[i][0] && mat[i][0] == 'O'){
                dfs(i, 0, vis, mat, delrow, delcol);
            }
            // last col 
            if (!vis[i][m-1] && mat[i][m-1] == 'O'){
                dfs(i, m-1, vis, mat, delrow, delcol);
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!vis[i][j]  && mat[i][j] == 'O'){
                    mat[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(int row, int col, boolean[][] vis, char[][] mat, int[] delrow, int[] delcol){
        vis[row][col] = true;
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < 4; i++){
            int nrow = row+ delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && mat[nrow][ncol] == 'O'){
                dfs(nrow, ncol, vis, mat ,delrow, delcol);
            }
        }
    }
}