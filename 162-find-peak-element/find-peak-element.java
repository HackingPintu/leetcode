class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int i=0,j=nums.length-1;
        while(i<j){
            int k=(i+j)/2;
            if(nums[k]>nums[k+1]){
                j=k;
            }else{
                i=k+1;
            }
        }
        return i;
    }
}