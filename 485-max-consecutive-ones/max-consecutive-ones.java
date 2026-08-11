class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int j = 0;
        int n = nums.length, max = 0;
        for (int i = 0; i < n; i++){
            if (nums[i] == 0){
                j = i + 1;
            }else{
                max = Math.max(max, i - j + 1);
            }
        }

        return max;
    }
}