class Solution {
    public boolean threeFibonacciSum(int n) {
        int a = 0;
        int b = 1;
        int c = 1;

        int sum = a + b + c;
        if (sum == n) return true;
        while (sum < n){
            a = b;
            b = c;
            c = a + b;

            sum = a + b + c;
            if (sum == n) return true;
            
        }

        return false;
    }
}