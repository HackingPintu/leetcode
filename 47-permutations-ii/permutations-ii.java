class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        boolean[] visited = new boolean[nums.length];

        List<List<Integer>> list = new ArrayList<>();


        findPermutation(nums, visited, list, new ArrayList<>());

        return list;


        
    }

    public void findPermutation(int[] nums, boolean visited[], List<List<Integer>> res, List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;

            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

            list.add(nums[i]);

            visited[i] = true;

            findPermutation(nums, visited, res, list);

            list.remove(list.size() - 1);

            visited[i] = false;

        }
    }
}