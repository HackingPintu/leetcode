class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] mat = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(mat[i], (int) 1e8);
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            mat[u][v] = wt;
            mat[v][u] = wt;
            mat[u][u] = 0;
            mat[v][v] = 0;
        }
        int[] city = new int[n];    
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i == j || mat[i][k] == (int)1e8 || mat[k][j] == (int) 1e8) continue;
                    if(mat[i][k] + mat[k][j] < mat[i][j]){
                        mat[i][j] = mat[i][k] + mat[k][j];
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int dist : mat[i]){
                if(dist <= distanceThreshold){
                    city[i]++;
                }
            }
        }
        int ans = 0;
        for(int i = 1; i < n; i++){
            if(city[i] < city[ans]){
                ans = i;
            }else if(city[i] == city[ans]){
                ans = i;
            }
        }
        return ans;

    }
}