class Solution {
    public String shortestCommonSupersequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length()+1];

        for (int i = 0 ; i <= text1.length(); i++){
            dp[i][0] = 0;
        }
        for (int j = 0 ; j <= text2.length(); j++){
            dp[0][j] = 0;
        }

        for (int i = 1; i <= text1.length(); i++){
            for (int j = 1; j <= text2.length(); j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
 
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        StringBuilder ans = new StringBuilder();
        int i = text1.length() , j = text2.length();
        while (i > 0 && j > 0){
            if (text1.charAt(i-1) == text2.charAt(j-1)){      
                ans.append(text1.charAt(i-1));
                i--; j--;
            }
            else if (dp[i-1][j] > dp[i][j-1]){
                ans.append(text1.charAt(i-1));
                i--;
            }
            else {
                ans.append(text2.charAt(j-1));
                j--;
            }
        }

        while ( i > 0){
            ans.append(text1.charAt(i-1));
            i--;
        }
        while ( j > 0){
            ans.append(text2.charAt(j-1));
            j--;
        }
        ans.reverse();
        
        return ans.toString();

    }
}