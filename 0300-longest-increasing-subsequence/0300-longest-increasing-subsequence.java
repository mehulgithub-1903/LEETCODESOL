class Solution {
    public int lengthOfLIS(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int m = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    m = Math.max(m, dp[j]);
                }
            }
            dp[i] = m + 1;
        }
        int maxValue = 0;
        for (int i = 0; i < dp.length; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        return maxValue;
    }
}