class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for(int i = 1; i <= n; i++){
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1]; 
        }

        int pivot = -1;
        for(int i = 0; i < n; i++){
            int leftSum = prefixSum[i];
            int rightSum = prefixSum[n] - prefixSum[i + 1];
            if(leftSum == rightSum) return i;
        }

        return pivot;
    }
}