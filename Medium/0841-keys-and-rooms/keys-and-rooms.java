class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> list) {
        int n = list.size();
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        int count = 1;
        while(!q.isEmpty()){
            int current = q.poll();
            for (int it: list.get(current)){
                if (!vis[it]){
                    q.add(it);
                    count++;
                    vis[it] = true;
                }
            }

        }
        return count == n;
    }
}