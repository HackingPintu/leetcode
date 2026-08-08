class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(n - 1 > connections.length  ) return -1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] conn : connections){
            int u = conn[0];
            int v = conn[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        DisJointSet ds = new DisJointSet(n);
        for(int i = 0; i < n; i++){
            for(int j : adj.get(i)){
                int parentU = ds.findParent(i);
                int parentV = ds.findParent(j);

                if(parentU != parentV){
                    ds.unionBySize(i, j);
                }
            }
        }
        return ds.totalConnectedComponents() - 1;
    }
}

class DisJointSet{
    int[] parent;
    int[] size;

    public DisJointSet(int size){
        this.parent = new int[size];
        this.size = new int[size];

        for(int i = 0; i < size; i++){
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public int findParent(int i){
        if(i == parent[i]) return i;
        return parent[i] = findParent(parent[i]);
    }

    public void unionBySize(int u, int v){
        int parentU = findParent(u);
        int parentV = findParent(v);

        if(parentU != parentV){
            if(size[parentU] < size[parentV]){
                parent[parentV] = parentU;
                size[parentU] += size[parentV];
            }else{
                parent[parentU] = parentV;
                size[parentV] += size[parentU];
            }
        }
    }
    public int totalConnectedComponents(){
        int total = 0;
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == i) total++;
        }
        return total; 
    }
}