class Solution {
    public boolean isBipartite(int[][] graph) {
int v = graph.length;
        boolean[] vis = new boolean[v];
        int[] color = new int[v];
        for (int i = 0; i < v; i++){
            if(!vis[i]){
                if (!bfs(i, graph, vis, color)){
                    return false;
                };
            }

        }
        return true;
    }

    private static boolean bfs(int node, int[][] graph, boolean[] vis, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int current = q.remove();
            for (int it : graph[current]){
                if (!vis[it]){
                    q.offer(it);
                    color[it] = 1 - color[current];
                    vis[it] = true;
                }
                else if (color[current] == color[it]){
                    return false;
                }
            }
        }
        return true;
    }
}