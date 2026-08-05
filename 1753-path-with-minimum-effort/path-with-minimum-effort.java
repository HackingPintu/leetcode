class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] efforts = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;
        int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1 ,0}};
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.dist - b.dist
        );
        pq.offer(new Pair(0, 0, 0));
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            if(top.row == m - 1 && top.col == n - 1){
                return top.dist;
            }
            for(int[] d : dir){
                int newRow = top.row + d[0];
                int newCol = top.col + d[1];
                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n){
                    int jumpEffort = Math.abs(heights[top.row][top.col] - heights[newRow][newCol]);

                    int newMaxEffort = Math.max(top.dist, jumpEffort);

                    if (newMaxEffort < efforts[newRow][newCol]) {
                        efforts[newRow][newCol] = newMaxEffort;
                        pq.offer(new Pair(newMaxEffort, newRow, newCol));
                    }

                }
            }
        }
        return efforts[m - 1][n - 1];
        
    }
}
class Pair{
    int dist;
    int row;
    int col;
    public Pair(int dist, int row, int col){
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}