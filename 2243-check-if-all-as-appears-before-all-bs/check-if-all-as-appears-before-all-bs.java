class Solution {
    public boolean checkString(String s) {
        int firstBIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                firstBIndex = i;
                break;
            }
        }

        if (firstBIndex == -1) return true;

        for (int i = firstBIndex; i < s.length(); i++){
            if (s.charAt(i) == 'a') return false;
        }

        return true;

    }
}