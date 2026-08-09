class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(solve1(nums, n-2, dp1), solve2(nums, n - 1, dp2));
    }

    public int solve1(int[] nums, int n, int[] dp){
        if (n < 0) return 0;
        if (dp[n] != -1) return dp[n];
        int currentRob = solve1(nums, n - 2, dp) + nums[n];

        int skipRob = solve1(nums, n - 1, dp);

        return dp[n] = Math.max(currentRob, skipRob);
    }

    public int solve2(int[] nums, int n, int[] dp){
        if (n < 1) return 0;
        if (dp[n] != -1) return dp[n];
        int currentRob = solve2(nums, n - 2, dp) + nums[n];

        int skipRob = solve2(nums, n - 1, dp);

        return dp[n] = Math.max(currentRob, skipRob);
    }
}