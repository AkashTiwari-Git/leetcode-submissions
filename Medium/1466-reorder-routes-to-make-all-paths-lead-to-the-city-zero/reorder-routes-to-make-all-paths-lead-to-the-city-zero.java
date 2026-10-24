class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i=0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] arr : connections){
            // original raod u - v
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(new int[]{v, 1});
            adj.get(v).add(new int[]{u, 0});
        }

        boolean[] vis = new boolean[n];
        int[] count = new int[1];
        dfs(count, adj, vis, 0);



        return count[0];
    }


    private static void dfs(int[] count, List<List<int[]>> adj, boolean[] vis, int parent) {
        vis[parent] = true;
        for (int[] edge: adj.get(parent)){
            int child = edge[0];
            int cost = edge[1];

            if (!vis[child]){
                count[0] += cost;

                dfs(count, adj, vis, child);

            }
        }

    }
}