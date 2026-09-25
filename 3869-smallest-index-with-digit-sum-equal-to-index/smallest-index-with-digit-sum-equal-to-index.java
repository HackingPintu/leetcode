class Solution {
    public int smallestIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if (i == digitSum(nums[i])) return i;
        }

        return -1;
    }

    public int digitSum(int digit) {
        int sum = 0;
        while (digit > 0){
            sum +=(digit%10);
            digit /= 10;
        }

        return sum;
    }
}