

class Solution {
    private Long[][][][][] dp;
    private String s;
    private boolean isGood(int n) {
        if (n < 10) return true;
        String str = String.valueOf(n);
        boolean inc = true, dec = true;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) <= str.charAt(i - 1)) inc = false;
            if (str.charAt(i) >= str.charAt(i - 1)) dec = false;
        }
        return inc || dec;
    }

    private long solve(long n) {
        if (n <= 0) return 0;
        this.s = String.valueOf(n);
        int len = s.length();
        
        dp = new Long[len][150][11][5][2];
        return dfs(0, 0, -1, 0, true, false);
    }

    private long dfs(int pos, int sum, int prev, int trend, boolean isLimit, boolean isNum) {
        if (pos == s.length()) {
            if (!isNum) return 0;
            
            if (trend >= 1 && trend <= 3) return 1;
            
            return isGood(sum) ? 1 : 0;
        }

        int prevIdx = prev + 1;
        int numIdx = isNum ? 1 : 0;
        if (!isLimit && dp[pos][sum][prevIdx][trend][numIdx] != null) {
            return dp[pos][sum][prevIdx][trend][numIdx];
        }

        int up = isLimit ? (s.charAt(pos) - '0') : 9;
        long ans = 0;

        for (int d = 0; d <= up; d++) {
            boolean nextLimit = isLimit && (d == up);

            if (!isNum && d == 0) {
                
                ans += dfs(pos + 1, sum, -1, 0, nextLimit, false);
            } else {
                int nextTrend;
                if (!isNum) {
                    nextTrend = 1; 
                } else if (trend == 1) {
                    if (d > prev) nextTrend = 2;       
                    else if (d < prev) nextTrend = 3;  
                    else nextTrend = 4;                
                } else if (trend == 2) {
                    nextTrend = (d > prev) ? 2 : 4;
                } else if (trend == 3) {
                    nextTrend = (d < prev) ? 3 : 4;
                } else {
                    nextTrend = 4;
                }

                ans += dfs(pos + 1, sum + d, d, nextTrend, nextLimit, true);
            }
        }

        if (!isLimit) {
            dp[pos][sum][prevIdx][trend][numIdx] = ans;
        }
        return ans;
    }

    public long countFancy(long l, long r) {
        return solve(r) - solve(l - 1);
    }
}