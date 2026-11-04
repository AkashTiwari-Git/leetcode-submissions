class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] matrix = new boolean[numCourses][numCourses];

        for (int[] edge: prerequisites){
            int u = edge[0];
            int v = edge[1];
            matrix[u][v] = true;
        }
        

        for (int via = 0; via < numCourses; via++){
            for (int i = 0; i < numCourses; i++){
                for (int j = 0; j < numCourses; j++){
                    if (matrix[i][via] && matrix[via][j]){
                        matrix[i][j] = true;
                    }
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query: queries){
            int u = query[0];
            int v = query[1];
            if (matrix[u][v]){
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}