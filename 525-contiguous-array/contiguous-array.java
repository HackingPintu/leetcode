class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int longest = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int runningSum = 0;
        for (int i = 0; i < n; i++){
            if (nums[i] == 0) runningSum--;
            else runningSum++;
            if (map.containsKey(runningSum)){
                int len = i - map.get(runningSum);
                longest = Math.max(longest, len);
            }else {
                map.put(runningSum, i);
            }
        }

        return longest;
    }
}