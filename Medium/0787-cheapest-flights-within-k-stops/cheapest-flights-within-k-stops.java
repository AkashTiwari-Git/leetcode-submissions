class Solution {
    static class Pair implements Comparable<Pair> {
        int port;
        int cost;
        int flights;

        Pair(int _port, int _cost, int _flights){
            this.port = _port;
            this.cost = _cost;
            this.flights = _flights;
        }
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : flights) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        int[][] costs = new int[k+2][n];

        for (int[] row : costs){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        heap.offer(new Pair(src, 0, 0));
        costs[0][src] = 0;


        while(!heap.isEmpty()){
            Pair current = heap.poll();
            int u = current.port;
            int prevCost = current.cost;
            int currFlights = current.flights;
            if (prevCost > costs[currFlights][u]){
                continue;
            }

            if (u != dst && currFlights == k + 1){
               continue;
            }

            if (currFlights <= k + 1 && u == dst){
                return prevCost;
            }

            for (int[] edge : adj.get(u)){
                int v = edge[0];
                int newCost = prevCost + edge[1];
                int newFlights = currFlights + 1;

                if (newFlights <= k + 1 && newCost < costs[newFlights][v]){
                    costs[newFlights][v] = newCost;
                    heap.offer(new Pair(v, newCost, newFlights));
                }
            }
        }
        return -1;
    }
}