class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);
        // return solve(nums, n - 1, dp);

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++){
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;

        
    }
    
    // public int solve(int[] nums, int n, int[] dp) {
    //     if (n < 0) {
    //         return 0;
    //     }
    //     if(dp[n] != -1) return dp[n];
    //     int robCurrent = nums[n] + solve(nums, n - 2, dp);
        
    //     int skipCurrent = solve(nums, n - 1, dp);
        
    //     return dp[n] = Math.max(robCurrent, skipCurrent);
    // }
}
