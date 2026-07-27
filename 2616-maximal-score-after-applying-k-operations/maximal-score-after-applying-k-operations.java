class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int num : nums){
            pq.offer(num);
        }
        long sum = 0;
        while(k > 0){
            int top = pq.poll();
            sum += top;
            pq.offer((top + 2) / 3);
            k--;
        }

        return sum;
    }
}