class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // int n = nums.length;

        // boolean[] visited = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();

        // findPermutation(nums, list, visited, new ArrayList<>());

        permute(nums, 0, list);

        return list;



    }

    // public void findPermutation(int[] nums, List<List<Integer>> res, boolean visited[], List<Integer> list){
    //     if(list.size() == nums.length){
    //         res.add(new ArrayList<>(list));
    //         return;
    //     }

    //     for(int i = 0; i < nums.length; i++){
    //         if(!visited[i]){
    //             list.add(nums[i]);
    //             visited[i] = true;

    //             findPermutation(nums, res, visited, list);

    //             list.remove(list.size() - 1);
    //             visited[i] = false;

    //         }
    //     }
    // }

    public void permute(int[] nums, int idx, List<List<Integer>> list){
        if(idx == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                temp.add(nums[i]);
            }

            list.add(temp);
            
        }

        for(int i = idx; i < nums.length; i++){
                swap(i, idx, nums);
                permute(nums, idx + 1, list);
                swap(i, idx, nums);
            }
    }

    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}