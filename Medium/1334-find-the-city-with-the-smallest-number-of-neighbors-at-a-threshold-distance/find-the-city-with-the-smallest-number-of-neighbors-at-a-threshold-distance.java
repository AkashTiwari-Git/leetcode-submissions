class Solution {
     static class Pair implements Comparable<Pair>{
        int vertex;
        int dist;

        Pair(int _vertex, int _dist){
            this.vertex = _vertex;
            this.dist = _dist;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.dist, other.dist);
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int dist = edge[2];
            adj.get(u).add(new int[]{v, dist});
            adj.get(v).add(new int[]{u, dist});
        }

        int ans = Integer.MAX_VALUE;
        int minDist = Integer.MAX_VALUE;
        for (int i = n-1; i >=0; i--){
            int cityReached = dijkstra(n, i, adj, distanceThreshold);
            if (minDist > cityReached){
                ans = i;
                minDist = cityReached;
            }
        }
        return ans;
    }

    private static int dijkstra(int n , int node, List<List<int[]>> adj, int distanceThreshold){
        int count = 0;
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        heap.offer(new Pair(node, 0));
        distances[node] = 0;
        boolean[] vis = new boolean[n];

        while(!heap.isEmpty()){
            Pair current = heap.poll();
            int prevDist = current.dist;
            int u = current.vertex;

            if (prevDist > distances[u]){
                continue;
            }
            if (u != node && !vis[u] && prevDist <= distanceThreshold) {
                count ++;
                vis[u] = true;
            }

            for (int[] edge : adj.get(u)){
                int v = edge[0];
                int newDist = distances[u] + edge[1];

                if (newDist < distances[v] && newDist <= distanceThreshold){
                    distances[v] = newDist;
                    heap.offer(new Pair(v, newDist));
                }
            }
        }
        return count;
    }

}