class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        // int[] dp1 = new int[n];
        // int[] dp2 = new int[n];
        // Arrays.fill(dp1, -1);
        // Arrays.fill(dp2, -1);
        // return Math.max(solve1(nums, n-2, dp1), solve2(nums, n - 1, dp2));
        int[] dp1 = new int[n];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n - 1; i++){
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }

        int[] dp2 = new int[n];
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);
        for(int i = 3; i < n; i++){
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }
        return Math.max(dp2[n - 1], dp1[n - 2]);
    }

    // public int solve1(int[] nums, int n, int[] dp){
    //     if (n < 0) return 0;
    //     if (dp[n] != -1) return dp[n];
    //     int currentRob = solve1(nums, n - 2, dp) + nums[n];

    //     int skipRob = solve1(nums, n - 1, dp);

    //     return dp[n] = Math.max(currentRob, skipRob);
    // }

    // public int solve2(int[] nums, int n, int[] dp){
    //     if (n < 1) return 0;
    //     if (dp[n] != -1) return dp[n];
    //     int currentRob = solve2(nums, n - 2, dp) + nums[n];

    //     int skipRob = solve2(nums, n - 1, dp);

    //     return dp[n] = Math.max(currentRob, skipRob);
    // }
}