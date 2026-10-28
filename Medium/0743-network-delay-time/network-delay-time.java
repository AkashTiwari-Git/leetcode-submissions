class Solution {
    static class Pair implements Comparable<Pair>{
        int node;
        int key;
        Pair(int _node, int _key){
            this.node = _node;
            this.key = _key;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.key, other.key);
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        heap.offer(new Pair(k, 0));
        while(!heap.isEmpty()){
            Pair current = heap.poll();
            int u = current.node;

            if (current.key > dist[u]) {
                continue;
            }

            for (int[] edge : adj.get(u)){
                int v = edge[0];
                int weight = edge[1];
                if (dist[u] + weight < dist[v]){
                    dist[v] = dist[u] + weight;
                    heap.offer(new Pair(v, dist[v]));
                }

            }
        }
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}