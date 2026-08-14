class Solution {
    public int maximumLengthSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        for (int j = 0; j < s.length(); j++){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while (map.get(s.charAt(j)) > 2){
                int value = map.get(s.charAt(i));
                map.put(s.charAt(i), value - 1);
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}