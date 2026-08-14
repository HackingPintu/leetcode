class Solution {
    public int maximumLengthSubstring(String s) {
        int max = 0;
        int[] count = new int[26];
        int i = 0;
        for (int j = 0; j < s.length(); j++){
            int pos = s.charAt(j) - 'a';
            count[pos] ++;
            while (count[pos] > 2){
                count[s.charAt(i) - 'a'] --;
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}