class Solution {
    public String smallestPalindrome(String s) {

        if(s.length() == 1) return s;
        PriorityQueue<Character> pq = new PriorityQueue<>();
        int l = 0, r = s.length() - 1;
        while(l < r){
            pq.offer(s.charAt(l));
            l++;
            r--;
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        String firstHalf = sb.toString(); 

        String secondHalf = sb.reverse().toString(); 

        StringBuilder result = new StringBuilder(firstHalf);
        if(l == r) {
            result.append(s.charAt(l)); 
        }
        result.append(secondHalf);

        return result.toString();
        
    }
}