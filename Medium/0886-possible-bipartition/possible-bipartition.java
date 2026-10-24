class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] arr : dislikes){
            int u = arr[0];
            int v = arr[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // bfs to find if the graph is bipartite
        boolean[] vis = new boolean[n+1];
        int[] color = new int[n+1];
        for (int i = 1; i <= n; i++){
            if (!vis[i]){
                if (!bfs(adj, vis, color, i)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfs(List<List<Integer>> adj, boolean[] vis, int[] color, int i) {
        vis[i] = true;
        color[i] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        while(!q.isEmpty()){
            int curr = q.poll();
            for (int it : adj.get(curr)){
                if (!vis[it]) {
                    color[it] = 1 - color[curr];
                    q.offer(it);
                    vis[it] = true;
                }
                else if (color[curr] == color[it]){
                    return false;
                } 
            }
        }
        return true;
    }
}