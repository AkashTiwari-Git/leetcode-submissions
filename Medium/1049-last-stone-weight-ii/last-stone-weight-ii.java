class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totSum = 0;

        for (int num : stones){
            totSum += num;
        }
        int target = totSum / 2;
        Boolean[][] dp = new Boolean[stones.length][target+1];
        int ans = Integer.MAX_VALUE;

        for (int s = 0; s <= target; s++) {

            if (f(stones.length - 1, s, stones, dp)) {
                ans = Math.min(ans, totSum - 2 * s);
            }
        }

        return ans;
        
    }

    private static boolean f(int i, int k,int[] stones, Boolean[][] dp){
        if (k == 0) return true;
        if (i < 0) return false;
        if (dp[i][k] != null) return dp[i][k]; 
        boolean pick = false;


        if (stones[i] <= k){
            pick = f(i -1, k - stones[i], stones, dp);
        }

        boolean notPick =  f(i -1, k,  stones, dp);

        dp[i][k] = pick || notPick;

        return dp[i][k];
    }
}