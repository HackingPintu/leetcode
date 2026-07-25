class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        solve(1, k, n, res, new ArrayList<>());
        return res;
    }

    public void solve(int start, int k, int n, List<List<Integer>> res, List<Integer> list){
        if(list.size() == k){
            if(n == 0){
                res.add(new ArrayList<>(list));
                return;
            }
        }
        

        for(int i = start; i <= 9; i++){
            if(i > n) break;

            list.add(i);
            solve(i + 1, k, n - i, res, list);
            list.remove(list.size() - 1);
        }
    }

    
}