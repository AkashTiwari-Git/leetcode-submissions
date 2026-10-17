class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());

            for (int j : graph[i]) {
                adj.get(i).add(j);
            }
        }

        boolean[] vis = new boolean[v];
        boolean[] path = new boolean[v];
        boolean[] check = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, path, check);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            if (check[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean dfs(int node, List<List<Integer>> adj,
                        boolean[] vis, boolean[] path,
                        boolean[] check) {

        vis[node] = true;
        path[node] = true;
        check[node] = false;

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                if (dfs(it, adj, vis, path, check)) {
                    return true;
                }
            } else if (path[it]) {
                return true;
            }
        }

        check[node] = true;
        path[node] = false;

        return false;
    }
}