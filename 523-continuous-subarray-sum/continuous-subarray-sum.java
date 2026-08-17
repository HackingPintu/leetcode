class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int runningSum = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            runningSum += nums[i];
            int rem = runningSum % k;
            if(map.containsKey(rem)){
                int idx = map.get(rem);
                if(i - idx > 1) return true;
            }else{

                map.put(rem, i);
            }
        }

        return false;
    }
}