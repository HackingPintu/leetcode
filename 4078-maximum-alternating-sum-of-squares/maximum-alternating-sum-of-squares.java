class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++){
            if (nums[i] < 0) nums[i] = -nums[i];
        }

        Arrays.sort(nums);
        long result = 0;
        int i = 0, j = n - 1;
        for(; i < j; i++, j--){
            result += (nums[j] * nums[j]) - (nums[i] * nums[i]);
        }
        if (i == j) result += (nums[i] * nums[i]);
        return result;
    }
}