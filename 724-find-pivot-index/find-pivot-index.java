class Solution {
    public int pivotIndex(int[] nums) {
        //brute
        int leftSum = 0;
        int n = nums.length;
        int rightSum = 0;
        for (int i = 1; i < n; i++) rightSum += nums[i];
        for (int i = 0; i < n - 1; i++) {
            if (leftSum == rightSum) return i;
            leftSum += nums[i];
            rightSum -= nums[i + 1];
        }
        rightSum = 0;
        if (leftSum == rightSum) return n - 1;
        return -1;
    }
}