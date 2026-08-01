class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = Integer.MAX_VALUE; 
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    
                    dfs(mat, i + 1, j, 1);
                    dfs(mat, i - 1, j, 1);
                    dfs(mat, i, j + 1, 1);
                    dfs(mat, i, j - 1, 1);
                }
            }
        }
        
        return mat;
    }
    
    private void dfs(int[][] mat, int row, int col, int dist) {
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[0].length) {
            return;
        }
        
        
        if (mat[row][col] <= dist) {
            return; 
        }
        
        mat[row][col] = dist;
        
        dfs(mat, row + 1, col, dist + 1);
        dfs(mat, row - 1, col, dist + 1);
        dfs(mat, row, col + 1, dist + 1);
        dfs(mat, row, col - 1, dist + 1);
    }
}