class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int max = -1;
        ans[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--){
            if (arr[i + 1] > max){
                max = arr[i + 1];
            }

            ans[i] = max;

        }

        return ans;
    }
}