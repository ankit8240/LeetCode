class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        
        
        int[] pref = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + stoneValue[i];
        }
        
        
        int[][] dp = new int[n][n];
        
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                for (int k = i; k < j; k++) {
                    int leftSum = pref[k + 1] - pref[i];
                    int rightSum = pref[j + 1] - pref[k + 1];
                    
                    if (leftSum < rightSum) {
                        
                        dp[i][j] = Math.max(dp[i][j], leftSum + dp[i][k]);
                    } else if (rightSum < leftSum) {
                        
                        dp[i][j] = Math.max(dp[i][j], rightSum + dp[k + 1][j]);
                    } else {
                        
                        int maxSubPath = Math.max(dp[i][k], dp[k + 1][j]);
                        dp[i][j] = Math.max(dp[i][j], leftSum + maxSubPath);
                    }
                }
            }
        }
        
        
        return dp[0][n - 1];
    }
}
