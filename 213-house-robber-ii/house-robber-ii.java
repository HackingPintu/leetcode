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
        // int[] dp1 = new int[n];
        int prev12 = nums[0];
        int prev11 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n - 1; i++){
            int curr = Math.max(prev11, prev12 + nums[i]);
            prev12 = prev11;
            prev11 = curr;
        }

        // int[] dp2 = new int[n];
        int prev22 = nums[1];
        int prev21 = Math.max(nums[1], nums[2]);
        for(int i = 3; i < n; i++){
            int curr = Math.max(prev21, prev22 + nums[i]);
            prev22 = prev21;
            prev21 = curr;
        }
        return Math.max(prev11, prev21);
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