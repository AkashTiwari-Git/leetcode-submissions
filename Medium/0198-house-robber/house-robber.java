class Solution {
    public int rob(int[] houses) {
        int n = houses.length;
        int prev = houses[0];
        int prev2 = 0;
        for (int i = 1; i< n; i++){
            int take = houses[i];
            if (i > 1){
                take += prev2;
            }
            int notTake = prev;

            int cur = Math.max(take, notTake);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}