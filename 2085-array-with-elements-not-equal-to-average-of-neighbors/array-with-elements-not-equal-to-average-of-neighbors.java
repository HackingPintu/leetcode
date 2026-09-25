class Solution {
    public int[] rearrangeArray(int[] nums) {
       int n = nums.length - 1;
       Arrays.sort(nums);
       for (int i = 1; i < n; i += 2){
            
                int temp = nums[i + 1];
                nums[i + 1] = nums[i];
                nums[i] = temp;
       }

       return nums;

    }
}