class Solution {
    public boolean isPossibleDivide(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int h : hand){
            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        while(map.size() != 0){
            int firstCard = map.firstKey();
            int firstCardCount = map.get(firstCard);
            if(firstCardCount > 1){
                map.put(firstCard, --firstCardCount);
            }else{
                map.remove(firstCard);
            }
            for(int i = 1; i < groupSize; i++){
                if(!map.containsKey(firstCard + i)) return false;
                int cardCount = map.get(firstCard + i);
                if(cardCount > 1){
                    map.put(firstCard + i, --cardCount);
                }else{
                    map.remove(firstCard + i);
                }

            }
        }

        return true;
    }
}