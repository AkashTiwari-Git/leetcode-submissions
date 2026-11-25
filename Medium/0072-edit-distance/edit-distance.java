class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for (int[] r: dp){
            Arrays.fill(r, -1);
        }

        return f(n-1, m-1, word1, word2, dp);
    }

    static int f(int i , int j, String s1, String s2, int[][] dp){
        if (i < 0) return j +1;
        if (j < 0) return i +1;
        if (dp[i][j]!=-1) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = f(i-1, j-1, s1, s2, dp);
            return dp[i][j];
        }
        dp[i][j] = 1 + Math.min(f(i-1, j, s1, s2, dp), Math.min(f(i, j-1, s1, s2, dp), f(i-1, j-1, s1,s2, dp)));
        return dp[i][j];
    }
}