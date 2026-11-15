class Solution {
    public static int rob1(int[] houses) {
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

    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1) return nums[0];
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];

        for (int i = 0; i < n; i++){
            if (i != 0){
                temp1[i] = nums[i];
            }
            if (i != n-1){
                temp2[i] = nums[i];
            }
        }

        return Math.max(rob1(temp1), rob1(temp2));

    }
}