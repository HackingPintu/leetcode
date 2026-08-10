class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            pq.add(new int[]{matrix[i][0], i, 0});
        }
        int[] top =  null;
        for(int i = 0; i < k; i++){
            top = pq.poll();
            int row = top[1];
            int col = top[2];
            if(col < n -1){
                pq.add(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }

        return top[0]; 
    }
}