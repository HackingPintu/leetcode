class Solution {
    public int myAtoi(String s) {
        if(s.length() == 0 || s == null) return 0;
        final int INT_MAX = Integer.MAX_VALUE;
        final int INT_MIN = Integer.MIN_VALUE;
        int sign = 1;
        int n = s.length();
        int i = 0;
        while(i < n && s.charAt(i) == ' '){
            i++;
        }

        if(i == n) return 0;

        if(s.charAt(i) == '-'){
            sign = -1;
            i++;
        }else if(s.charAt(i) == '+'){
            i++;
        }
        long res = 0;
        while(i < n && Character.isDigit(s.charAt(i))){
            int num = s.charAt(i) - '0';
            res = res * 10 +  num;
            if(res * sign <= INT_MIN){
                return INT_MIN;
            }
            if(res * sign >= INT_MAX) return INT_MAX;
            i++;
        }

        return (int)(res * sign); 
    }
}