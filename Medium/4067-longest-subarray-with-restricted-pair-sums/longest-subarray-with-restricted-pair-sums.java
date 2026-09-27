class Solution {
    public int maxSubarray(int[] nums) {
           
//        Hashtable<int[], Integer> map = new Hashtable<>();
        boolean[] freq = new boolean[1001];
        int maxSum = 0, sum = 0;
        int l = 0, r = 0;
        while(r < nums.length){
            // find the sum of pairs of a new window
            for (int i = l; i <= r; i++){
                for (int j = i; j <=r; j++){
                    if (i == j) continue;
                    freq[nums[i] + nums[j]] = true;
                }
            }
            // check if any of pairs sum exists
            boolean invalid = false;
            for (int i = l; i <= r; i++){
                if (freq[nums[i]]){
                    invalid = true;
                    break;
                }
            }
            if (invalid) {
                Arrays.fill(freq, false);
                l++;
            }
            if (!invalid){
                maxSum = Math.max(maxSum, r - l + 1);
                r++;
            }
        }
        return maxSum;
    }

}