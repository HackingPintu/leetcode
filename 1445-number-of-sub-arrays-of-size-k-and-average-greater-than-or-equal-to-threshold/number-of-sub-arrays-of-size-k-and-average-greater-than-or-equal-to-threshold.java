class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0;
        int sum = 0;
        while (left < k){
            sum += arr[left++];
        }
        int count = 0;
        if (sum/k >= threshold) count++;
        left = 0;
        int right = k;
        while (right < arr.length){
            sum -= arr[left++];
            sum += arr[right++];

            if (sum/k >= threshold) count++;
        }

        return count;

    }
}