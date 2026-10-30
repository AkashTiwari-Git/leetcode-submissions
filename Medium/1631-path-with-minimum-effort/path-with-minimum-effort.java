class Solution {
    static class Pair implements Comparable<Pair>{
        int row;
        int col;
        int effort;

        Pair(int row, int col, int effort){
            this.row = row;
            this.col = col;
            this.effort = effort;
        }

        @Override
        public int compareTo(Pair pair) {
            return Integer.compare(this.effort, pair.effort);
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length; int n = heights[0].length;
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        int[][] distances = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                distances[i][j] = Integer.MAX_VALUE;
            }
        }

        heap.offer(new Pair(0,0,0));
        distances[0][0] = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!heap.isEmpty()){
            Pair current = heap.poll();
            int row = current.row;
            int col = current.col;
            int prevEffort = current.effort;

            if (prevEffort > distances[row][col]){
                continue;
            }

            if (row == m - 1 && col == n - 1) {
                return prevEffort;
            }

            for (int i = 0; i < 4; i++){
                int new_r = row + dr[i];
                int new_c = col + dc[i];
                if (new_r < 0 || new_c < 0 || new_r >= m || new_c >= n) {
                    continue;
                }

                int newEffort = Math.max(prevEffort, Math.abs(heights[row][col] - heights[new_r][new_c]));
                if (distances[new_r][new_c] > newEffort){
                    distances[new_r][new_c] = newEffort;
                    heap.offer(new Pair(new_r, new_c, newEffort));
                }
            }
        }
        return distances[m-1][n-1];

    }
}