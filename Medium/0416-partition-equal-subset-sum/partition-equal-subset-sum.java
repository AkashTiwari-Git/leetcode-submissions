class Solution {
    public boolean canPartition(int[] nums) {
        int totSum = 0;
        for (int i = 0; i<nums.length; i++){
            totSum += nums[i];
        }
        if (totSum % 2 != 0) return false;
        int target = totSum / 2;
        return subsetSumToK(nums.length, target, nums);
    }

    static boolean subsetSumToK(int n, int k, int[] arr){
        boolean[] prev = new boolean[k+1];
        boolean[] cur = new boolean[k+1];
        prev[0] = true;
        if (arr[0] <= k) {
    prev[arr[0]] = true;
}
        for (int ind = 1; ind<n ; ind++){
            for (int target = 1; target <= k; target ++){
                boolean notTake = prev[target];
                boolean take = false;
                if (arr[ind] <= target) take = prev[target -arr[ind]];
                cur[target] = take | notTake;
            }
            prev = cur.clone();
        }
        return prev[k];
    }
}