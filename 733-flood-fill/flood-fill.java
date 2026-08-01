class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // int m = image.length, n = image[0].length;
        // int[][] mat = new int[m][n];
        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         mat[i][j] = image[i][j];
        //     }
        // }
       
        int originalColor = image[sr][sc];
        if (originalColor == color) {
            return image;
        }
        dfs(image, sr, sc, color, originalColor);
        return image;
    }

    public void dfs(int[][] mat, int sr, int sc, int color, int original) {
    if (sr < 0 || sr >= mat.length || sc < 0 || sc >= mat[0].length) {
        return;
    }
    if (mat[sr][sc] != original) {
        return;
    }
    mat[sr][sc] = color;
    
    dfs(mat, sr, sc + 1, color, original);
    dfs(mat, sr, sc - 1, color, original);
    dfs(mat, sr + 1, sc, color, original);
    dfs(mat, sr - 1, sc, color, original);
}
}