class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1]; 
        return solver(n, memo);
    }

    public int solver(int n, int[] memo) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        
        if (memo[n] != 0) {
            return memo[n];
        }
        
        return memo[n] = solver(n - 1, memo) + solver(n - 2, memo);
        // return memo[n];
    }
}