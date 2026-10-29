class Solution {
    static class Pair implements Comparable<Pair>{
        int vertex;
        double prob;

        Pair(int v, double prob){
            this.vertex = v;
            this.prob = prob;
        }

        @Override
        public int compareTo(Pair other) {
            return Double.compare(other.prob, this.prob);
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // make an adj list (undirected)
        List<List<double[]>> adj = new ArrayList<>();
        for (int i = 0; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            adj.get(u).add(new double[] {v, prob});
            adj.get(v).add(new double[]{u, prob});
        }

        PriorityQueue<Pair> heap = new PriorityQueue<>();

        double[] probs = new double[n];
        Arrays.fill(probs, -1);

        heap.offer(new Pair(start_node, 1));
        probs[start_node] = 1;

        while (!heap.isEmpty()){
            Pair current = heap.poll();
            int u = current.vertex;
            double prevProb = current.prob;

            if (prevProb < probs[u]){
                continue;
            }

            for (double[] edge : adj.get(u)){
                int v = (int)edge[0];

                if (probs[u] * edge[1] > probs[v]){
                    probs[v] = probs[u] * edge[1];
                    heap.offer(new Pair(v, probs[v]));
                }
            }
        }
        return Math.max(0.0, probs[end_node]);
    }
}