
import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = knapsackRec(0, amount, coins, dp);

        return ans >= Integer.MAX_VALUE / 2 ? -1 : ans;
    }

    static int knapsackRec(int i, int amount, int[] coins, int[][] dp) {

        if (amount == 0) return 0;

        if (i == coins.length) return Integer.MAX_VALUE / 2;

        if (dp[i][amount] != -1) return dp[i][amount];

        int pick = Integer.MAX_VALUE / 2;

        if (coins[i] <= amount) {
            pick = 1 + knapsackRec(i, amount - coins[i], coins, dp);
        }

        int notPick = knapsackRec(i + 1, amount, coins, dp);

        dp[i][amount] = Math.min(pick, notPick);

        return dp[i][amount];
    }
}
