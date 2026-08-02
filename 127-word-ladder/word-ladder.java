class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord); 
        int steps = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String curr = queue.poll();
                char[] currChars = curr.toCharArray();
                for (int j = 0; j < currChars.length; j++) {
                    char originalChar = currChars[j]; 
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (originalChar == c) continue; 
                        currChars[j] = c; 
                        String newWord = new String(currChars); 
                        if (newWord.equals(endWord)) {
                            return steps + 1;
                        }
                        if (set.contains(newWord)) {
                            set.remove(newWord);
                            queue.offer(newWord);
                        }
                    }
                    currChars[j] = originalChar; 
                }
            }
            steps++; 
        }
        return 0;
    }
}