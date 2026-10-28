class Solution {
    static class Node {
        int row;
        int col;
        int dist;

        Node(int _row, int _col, int _dist){
            this.row = _row;
            this.col = _col;
            this.dist = _dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        Queue<Node> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        int[] delrow = {-1,-1,0,1,1,1,0,-1};
        int[] delcol = {0,1,1,1,0,-1,-1,-1};
        if (grid[0][0] == 0){
            q.offer(new Node(0, 0 , 1));
            vis[0][0] = true;
        }
        if (n == 1 && grid[0][0] == 0){
            return 1;
        }

        while(!q.isEmpty()){
            Node current = q.poll();
            int row = current.row;
            int col = current.col;
            int dist = current.dist;
            for (int i = 0; i < 8; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if (nrow == n - 1 && ncol == n - 1 && grid[nrow][ncol] == 0){
                    return dist + 1;
                }

                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < n && !vis[nrow][ncol] && grid[nrow][ncol] == 0){
                    vis[nrow][ncol] = true;
                    q.offer(new Node(nrow, ncol, dist + 1));
                }
            }
        }
        return -1;
    }
}