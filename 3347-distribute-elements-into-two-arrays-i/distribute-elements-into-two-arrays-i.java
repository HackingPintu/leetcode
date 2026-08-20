class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(nums[0]);
        list2.add(nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if(list1.get(list1.size() - 1) > list2.get(list2.size() - 1)){
                list1.add(nums[i]);
            }else {
                list2.add(nums[i]);
            }
        }

        int[] ans = new int[nums.length];
        int k = 0;
        for(int i : list1){
            ans[k++] = i;
        }
        for(int i : list2){
            ans[k++] = i;
        }

        return ans;
    }
}