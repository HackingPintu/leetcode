class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int[] remainderCounts = new int[k]; 
        remainderCounts[0] = 1; 
        
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
            int rem = prefixSum % k;
            
            if (rem < 0) {
                rem = (rem + k) % k; 
            }
            
            count += remainderCounts[rem];
            
            remainderCounts[rem]++;
        }
        
        return count;
    }
}