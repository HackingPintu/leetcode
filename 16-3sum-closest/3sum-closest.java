class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int closest = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++){
            int j = i + 1;
            int k = n - 1;

            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target){
                    return sum;
                }else if (sum > target){
                    k--;
                }else j++;

                int dist = Math.abs(target - sum);
                if (closest > dist){
                    closest = dist;
                    ans = sum; 
                }
            }
        }

        return ans;

    }
}