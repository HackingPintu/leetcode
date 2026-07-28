class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        String prev = countAndSay(n - 1);
        
        StringBuilder current = new StringBuilder();
        int count = 1;
        
        for (int i = 0; i < prev.length(); i++) {
            if (i == prev.length() - 1 || prev.charAt(i) != prev.charAt(i + 1)) {
                current.append(count);
                current.append(prev.charAt(i));
                count = 1;
            } else {
                count++;
            }
        }
        
        return current.toString();
    }
}