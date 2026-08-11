class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int start = 0, end = 0;
        int max = Integer.MIN_VALUE;
        for (; end < nums.length; end++){
            sum += nums[end];
            max = Math.max(sum, max);
            if (sum < 0){
                sum = 0;
                start = end;
            } 
        }
        for (int i = start; i < end; i++){
            System.out.println(nums[i]);
        }
        return max;
    }
}