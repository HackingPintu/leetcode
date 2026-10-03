class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++){
            if (nums[i] == 0) nums[i] = -1;
        }
        int longest = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int runningSum = 0;
        for (int i = 0; i < n; i++){
            runningSum += nums[i];
            if (map.containsKey(runningSum)){
                int len = i - map.get(runningSum);
                longest = Math.max(longest, len);
            }

            map.putIfAbsent(runningSum, i);
        }

        return longest;
    }
}