class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int breakPoint = -1;
        for (int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                breakPoint = i;
                break;
            }
        }
        if(breakPoint == -1) reverseArray(nums, 0, n - 1);
        else{
            for (int i = n - 1; i >= breakPoint; i--){
                if (nums[i] > nums[breakPoint]){
                    int temp = nums[i];
                    nums[i] =  nums[breakPoint];
                    nums[breakPoint] = temp;
                    break;
                }
            }
            reverseArray(nums, breakPoint + 1, n - 1);
        }
        

    }

    public void reverseArray(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}