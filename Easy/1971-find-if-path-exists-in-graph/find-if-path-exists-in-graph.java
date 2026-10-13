//there : 1917

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] vis = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        return dfs(source, destination, vis, list);
    }

    private static boolean dfs(int s,int e, boolean[] vis,  List<List<Integer>> list ){
        if(s == e){
            return true;
        }
        if (vis[s]){
            return false;
        }

        vis[s] = true;

        for (int neighbour: list.get(s)){
            if(dfs(neighbour,e,vis, list)){
                return true;
            }
        }

        return false;

    }
}