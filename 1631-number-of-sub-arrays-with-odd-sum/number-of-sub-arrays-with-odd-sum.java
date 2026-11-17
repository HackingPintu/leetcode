class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        int prefixSum = 0;
        int evenCount = 1; 
        int oddCount = 0;
        int ans = 0;

        for (int num : arr) {
            prefixSum += num;

            if (prefixSum % 2 == 0) {
                ans = (ans + oddCount) % MOD;
                evenCount++;
            } else {
                ans = (ans + evenCount) % MOD;
                oddCount++;
            }
        }

        return ans;
    }
}