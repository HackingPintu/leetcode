class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        // int[] prefixSum = new int[n + 1];
        int leftSum = 0;

        // for (int i = 1; i <= n; i++){
        //     prefixSum[i] = nums[i - 1] + prefixSum[i - 1]; 
        // }
        int rightSum = 0;
        for (int i = 1; i < n; i++){
           rightSum += nums[i];
        }
        int i = 0;
        for (; i < n - 1; i++){
            // int leftSum = prefixSum[i];
            // int rightSum = prefixSum[n] - prefixSum[i + 1];
            // if (leftSum == rightSum) return i;
            if(leftSum == rightSum) return i;
            leftSum += nums[i];
            rightSum -= nums[i + 1];
        }
        return leftSum == rightSum ? i : -1;
        // if(i == n - 1){
        //     leftSum += nums[i];
        //     rightSum = 0;
        //     System.out.println(leftSum +" and "+ rightSum);
        //     if(leftSum == rightSum) return i;
        // }
    }
}