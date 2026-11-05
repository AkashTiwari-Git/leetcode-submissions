class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Integer> map = new HashMap<>();
        int id = 0;

        for (List<String> edge : equations){
            String u = edge.get(0);
            String v = edge.get(1);

            if (!map.containsKey(u)){
                map.put(u, id++);
            }
            if (!map.containsKey(v)){
                map.put(v, id++);
            }
        }

        double[][] matrix = new double[id][id];

        int counter = 0;
        for (List<String> edge : equations){
            String us = edge.get(0);
            String vs = edge.get(1);

            double wt = values[counter];
            int u = map.get(us);
            int v = map.get(vs);
            matrix[u][v] = wt;
            matrix[v][u] = 1 /  wt;
            counter++;
        }

        for (int i = 0; i < id; i++){
            matrix[i][i] = 1;
        }

        for (int via = 0; via < id; via++){
            for (int i = 0; i < id; i++){
                for (int j = 0; j < id; j++){
                    if (matrix[i][via] != 0.0 && matrix[via][j] != 0.0 && matrix[i][j] == 0) {
                        matrix[i][j] = matrix[i][via] * matrix[via][j];
                    }
                }
            }
        }

        double[] ans = new double[queries.size()];
        int i = 0;
        for (List<String> query: queries){
            String us = query.get(0);
            String vs = query.get(1);
            if (!map.containsKey(us) || !map.containsKey(vs)){
                ans[i] = -1;
                i++;
                continue;
            }
            int u = map.get(us);
            int v = map.get(vs);
            double a = matrix[u][v] == 0 ? -1 : matrix[u][v];
            ans[i] = a;
            i++;
        }

        return ans;
    }
}