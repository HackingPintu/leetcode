class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] arr = new int[graph.length];
        Arrays.fill(arr, -1);
        for (int k = 0; k < graph.length; k++) {
            if (arr[k] == -1) {
                if(!dfs(graph, arr, k)){
                    return false;
                }
                // Queue<Integer> queue = new LinkedList<>();
                // queue.add(k);
                // arr[k] = 0;
                // while (!queue.isEmpty()) {
                //     int node = queue.poll();
                //     for (int i = 0; i < graph[node].length; i++) {
                //         int neighbor = graph[node][i];
                //         if (arr[neighbor] == -1) {
                //             arr[neighbor] = 1 - arr[node]; 
                //             queue.add(neighbor);
                //         } else if (arr[neighbor] == arr[node]) {
                //             return false; 
                //         }
                //     }
                // }
            }
        }
        
        return true;
    }

    public boolean dfs(int[][] graph, int[] arr, int node) {
    for (int i = 0; i < graph[node].length; i++) {
        int neighbour = graph[node][i];
        if (arr[neighbour] == -1) {
            arr[neighbour] = 1 - arr[node];
            if (!dfs(graph, arr, neighbour)) {
                return false;
            }
        } 
        else if (arr[neighbour] == arr[node]) {
            return false;
        }
    }    
    return true;
}
}