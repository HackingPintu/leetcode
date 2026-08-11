class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
           
            if (!java.util.Objects.equals(mapS.get(s.charAt(i)), mapT.get(t.charAt(i)))) {
                return false;
            }
            
           
            mapS.put(s.charAt(i), i);
            mapT.put(t.charAt(i), i);
        }
        
        return true;
    }
}