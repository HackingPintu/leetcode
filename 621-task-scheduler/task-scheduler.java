class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : freq) {
            if (count > 0) pq.offer(count);
        }
        
        int total = 0;
        
        while (!pq.isEmpty()) {
            List<Integer> waitList = new ArrayList<>();
            int cycle = n + 1; 
            
            while (cycle > 0 && !pq.isEmpty()) {
                int currentFreq = pq.poll();
                if (currentFreq > 1) {
                    waitList.add(currentFreq - 1);
                }
                total++; 
                cycle--; 
            }
            
            for (int remainingFreq : waitList) {
                pq.offer(remainingFreq);
            }
            
            if (pq.isEmpty()) {
                break;
            }
        
            total += cycle; 
        }
        
        return total;
    }
}