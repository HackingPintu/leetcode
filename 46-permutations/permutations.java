class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;

        boolean[] visited = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();

        findPermutation(nums, list, visited, new ArrayList<>());

        return list;



    }

    public void findPermutation(int[] nums, List<List<Integer>> res, boolean visited[], List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                list.add(nums[i]);
                visited[i] = true;

                findPermutation(nums, res, visited, list);

                list.remove(list.size() - 1);
                visited[i] = false;

            }
        }
    }
}