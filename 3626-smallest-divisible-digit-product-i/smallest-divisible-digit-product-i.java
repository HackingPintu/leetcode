class Solution {
    public int smallestNumber(int n, int t) {
        int ans = 0;
        for(int i = n; i < Integer.MAX_VALUE; i++){
            int mul = 1;
            int copy = i;
            while(copy > 0){
                mul *= (copy % 10);
                copy /= 10;
            }
            if(mul % t == 0) {
                ans = i;
                break;
            }
        }
        return ans; 
    }
}