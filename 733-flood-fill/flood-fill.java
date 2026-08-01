class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        int[][] mat = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = image[i][j];
            }
        }
        boolean[][] visited = new boolean[m][n];
        int originalColor = mat[sr][sc];
        dfs(mat, sr, sc, color, originalColor, visited);
        return mat;
    }

    public void dfs(int[][] mat, int sr, int sc, int color, int original, boolean[][] visited) {
    if (sr < 0 || sr >= mat.length || sc < 0 || sc >= mat[0].length) {
        return;
    }
    
    if (visited[sr][sc] || mat[sr][sc] != original) {
        return;
    }
    
    visited[sr][sc] = true;
    mat[sr][sc] = color;
    
    dfs(mat, sr, sc + 1, color, original, visited);
    dfs(mat, sr, sc - 1, color, original, visited);
    dfs(mat, sr + 1, sc, color, original, visited);
    dfs(mat, sr - 1, sc, color, original, visited);
}
}