class Solution {
    public long countCommas(long n) {
        if (n < 999) return 0;

        int digits = countDigit(n);
        System.out.println(digits);
        long totalCommas = 0;
        while (digits > 0){
            long comma = n - (long)(Math.pow(10, 3 * (digits))) + 1;
            totalCommas += comma;
            digits--;
        }
        return totalCommas;

    }

    public int countDigit(long n) {
        int totalDigits = 0;
        while (n > 0){
            totalDigits++;
            n /= 10;
        }

        return (int) (Math.ceil((double)totalDigits / 3) - 1) ;
    }
}