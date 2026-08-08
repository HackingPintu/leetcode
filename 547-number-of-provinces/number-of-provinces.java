class Solution {
    public int findCircleNum(int[][] isConnected) {
        // int total = 0;
        // int len = isConnected.length;
        // boolean[] visited = new boolean[len];
        // for(int i = 0; i < len; i++){
        //     if(!visited[i]){
        //         total++;
        //         dfs(isConnected, visited, i);
        //     }
        // }

        // return total;
        List<List<Integer>> adj = new ArrayList<>();
        int size = isConnected.length;
        for(int i = 0; i <= size; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < isConnected[i].length; j++){
                if(i == j) continue;
                if(isConnected[i][j] == 1){
                    adj.get(i + 1).add(j + 1);
                }
            }
        }
        DisJointSet ds = new DisJointSet(size + 1);
        for(int i = 0; i <= size; i++){
            for(int j : adj.get(i)){
                int parentU = ds.findParent(i);
                int parentV = ds.findParent(j);
                if(parentU != parentV){
                    ds.unionBySize(i, j);
                }
            }
        }

        return ds.noOfParent();
    }

    public void dfs(int[][] isConnected, boolean[] visited, int n){
        visited[n] = true;
        for(int i = 0; i < isConnected[n].length; i++){
            if(!visited[i] && isConnected[n][i] == 1){
                dfs(isConnected, visited, i);
            }
        }
    }

    
}
class DisJointSet{
    int[] parent;
    int[] size;

    public DisJointSet(int size){
        parent = new int[size + 1];
        this.size = new int[size + 1];

        for(int i = 0; i < size; i++){
            parent[i] = i;
            this.size[i] = 1;
        }
    }    

    public void unionBySize(int u, int v){
        int parentU = findParent(u);
        int parentV = findParent(v);
        if(parentU != parentV){
            if(size[parentU] < size[parentV]){
                parent[parentU] = parentV;
                size[parentV] += size[parentU];
            }else{
                parent[parentV] = parentU;
                size[parentU] += size[parentV];
            }
        }
    }    
    public int findParent(int i){
        if(i == parent[i]) return i;
        return parent[i] = findParent(parent[i]);
    }
     public int noOfParent(){
        int n = -1;
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == i) n++;
        }

        return n;
    }
    
}