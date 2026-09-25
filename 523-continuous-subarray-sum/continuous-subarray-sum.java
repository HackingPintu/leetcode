class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        map.put(0, - 1);
        for (int i = 0; i < n; i++){
            prefixSum += nums[i];
            int rem = prefixSum % k;
            if (map.containsKey(rem)){
                int idx = map.get(rem);
                if(i - idx > 1) return true;
            }else{
                map.put(rem, i);
            }
        }

        return false;
    }
}