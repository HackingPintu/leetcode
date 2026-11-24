class Solution {
    public int maxLength(int[] nums) {
        int max = 0;
        int n = nums.length;
        long prod = 1;
        int gcd = 1, lcm = 1;
        int i = 0;
        int[] gcdPre = new int[n];
        int[] gcdSuff = new int[n];
        gcdPre[0] = nums[0];
        gcdSuff[n - 1] = nums[n - 1];
        for (int k = 1; k < n; k++) {
            gcdPre[k] = gcd(gcdPre[k - 1], nums[k]);
            gcdSuff[n - k - 1] = gcd(gcdSuff[n - k], nums[n - k - 1]);
        }

        for (int j = 0; j < n; j++) {
            for (int start = 0; start <= j; start++) {
                i = start;
                prod = 1;
                gcd = 0;
                lcm = 1;
                boolean overflow = false;

                for (int k = i; k <= j; k++) {
                    if (prod > Long.MAX_VALUE / nums[k]) {
                        overflow = true;
                        break;
                    }
                    prod *= nums[k];
                    gcd = (gcd == 0) ? nums[k] : gcd(gcd, nums[k]);
                    lcm = lcm(lcm, nums[k]);
                }

                if (!overflow && prod == (long) gcd * lcm) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }

    private int gcd(int a, int b) {
        int min = Math.min(a, b);
        while (min > 0) {
            if (a % min == 0 && b % min == 0) break;
            min--;
        }
        return min;
    }

    private int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}