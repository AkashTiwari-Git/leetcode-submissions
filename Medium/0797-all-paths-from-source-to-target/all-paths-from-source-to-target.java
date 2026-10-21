class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
int v = graph.length;
        List<List<Integer>> result = new ArrayList<>();
        dfs(new ArrayList<>(), result, graph, 0, v - 1);
        return result;
    }

    private static void dfs(ArrayList<Integer> list,List<List<Integer>> result, int[][] graph, int node, int target) {
        list.add(node);
        if (node == target){
            result.add(new ArrayList<>(list));
            list.removeLast();
            return;
        }

        for (int element : graph[node]){
            dfs(list, result, graph, element, target);

        }
        if (list.size() > 1){
            list.removeLast();
        }
    }
}