class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int totalProduct = 1;
        int zeroFound = 0;
        int idx = 0;
        for (int i = 0; i < n; i++){
            if (nums[i] != 0) totalProduct *= nums[i];
            else {
                zeroFound++;
                idx = i;
            }
        }
        int[] ans = new int[n];
        if (zeroFound == 0){
            for (int i = 0; i < n; i++){
                ans[i] = totalProduct / nums[i]; 
            }
        }else if(zeroFound == 1){
            ans[idx] = totalProduct;
        }
        return ans;
    }
}