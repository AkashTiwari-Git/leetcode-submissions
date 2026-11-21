class Solution {
    public int findTargetSumWays(int[] num, int tar) {
        return countPartitions(num.length, tar, num);
    }

    private static int findWays(int[] num, int tar){
        int n = num.length;
        int[] prev = new int[tar +1];
        int[] cur = new int[tar+1];
        prev[0] = 1;
        if (num[0] == 0) prev[0] = 2;
        if (num[0] != 0 && num[0] <= tar){
            prev[num[0]] = 1;
        }
        for (int ind = 1; ind < n; ind++){
            for (int sum = 0; sum<=tar; sum++){
                int notTake = prev[sum];
                int take = 0;
                if (num[ind] <= sum) take = prev[sum - num[ind]];
                cur[sum] = (notTake + take);
            }
            prev =cur.clone();
        }
        return prev[tar];
    }

    private static int countPartitions(int n, int d , int[] arr){
        int totsum = 0;
        for (int it : arr){
            totsum += it;
        }
        if (totsum -d < 0 || (totsum -d)%2 != 0) return 0;
        return findWays(arr, (totsum -d ) / 2);
    }

    
}