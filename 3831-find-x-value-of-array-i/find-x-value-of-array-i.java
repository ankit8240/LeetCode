class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] dp = new long[k];
        long[] ans = new long[k];

        for (int num : nums) {

            long[] next = new long[k];

            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newR = (int) ((long) r * num % k);
                    next[newR] += dp[r];
                }
            }

            int rem = num % k;
            next[rem]++;

            for (int r = 0; r < k; r++) {
                ans[r] += next[r];
            }

            dp = next;
        }

        return ans;
    }
}