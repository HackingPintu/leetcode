class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        subsets(nums, 0, list, new ArrayList<>());

        return list;
    }

    public void subsets(int[] nums, int idx, List<List<Integer>> res, List<Integer> list){
       
            res.add(new ArrayList<>(list));
            
        

        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i - 1]) continue;

            list.add(nums[i]);
            subsets(nums, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }    
    
}