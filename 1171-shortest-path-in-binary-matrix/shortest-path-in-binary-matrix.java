class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        Queue<Pair> queue = new LinkedList<>();
        int[][] direction = {{-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}};
        queue.add(new Pair(1, 0, 0)); 
        int n = grid.length;
        while(!queue.isEmpty()) {
            Pair top = queue.poll();
            if(top.row == n - 1 && top.col == n - 1) {
                return top.dist;
            }
            for(int[] d : direction) {
                int newRow = top.row + d[0];
                int newCol = top.col + d[1];
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                    queue.add(new Pair(top.dist + 1, newRow, newCol));
                    grid[newRow][newCol] = 1;
                }
            }
        }
        return -1; 
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