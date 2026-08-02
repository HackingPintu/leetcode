class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int j = 0; j < n; j++){
            if(grid[0][j] == 1){
                dfs(grid, 0, j, visited);
            }
            if(grid[m - 1][j] == 1){
                dfs(grid, m - 1, j, visited);
            }
        }
        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1){
                dfs(grid, i, 0, visited);
            }
            if(grid[i][n - 1] == 1){
                dfs(grid, i, n - 1, visited);
            }
        }
        int count = 0;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int row, int col, boolean[][] visited){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) return;

        visited[row][col] = true;
        dfs(grid, row - 1, col, visited);
        dfs(grid, row + 1, col, visited);
        dfs(grid, row, col + 1, visited);
        dfs(grid, row, col - 1, visited);
    }
}