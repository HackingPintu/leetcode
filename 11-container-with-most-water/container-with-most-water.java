class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, max = 0;
        while(l < r){
            int min = 0;
            if(height[l] < height[r]){
                min = height[l];
                max = Math.max(max, min * (r - l));
                l++;
            }else{
                min = height[r];
                max = Math.max(max, min * (r - l));
                r--;
            }
        }
        return max;
    }
}