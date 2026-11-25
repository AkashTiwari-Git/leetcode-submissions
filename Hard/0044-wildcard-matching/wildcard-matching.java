class Solution {
    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        Boolean[][] dp = new Boolean[n][m];
        
        return f(n-1, m-1, p, s, dp);
    }

    static boolean f(int i, int j, String p, String s, Boolean[][] dp){
        if (i < 0 && j < 0) return true;
        if (i < 0 && j >= 0) return false;
        if (j<0 && i>=0) {
            for (int ii=0; ii<=i; ii++){
                if (p.charAt(ii) != '*') return false;
            }
            return true;
        }
        if (dp[i][j]!=null) return dp[i][j];
        if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') {
            return dp[i][j] = f(i-1, j-1, p, s, dp);
        }
        if (p.charAt(i) =='*'){
            return  dp[i][j] = f(i-1, j, p, s, dp) || f(i, j-1, p, s, dp);
        }
        return dp[i][j] = false;
    }
}