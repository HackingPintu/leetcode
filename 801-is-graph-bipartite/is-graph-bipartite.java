class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] arr = new int[graph.length];
        Arrays.fill(arr, -1);
        for (int k = 0; k < graph.length; k++) {
            if (arr[k] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(k);
                arr[k] = 0;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int i = 0; i < graph[node].length; i++) {
                        int neighbor = graph[node][i];
                        if (arr[neighbor] == -1) {
                            arr[neighbor] = 1 - arr[node]; 
                            queue.add(neighbor);
                        } else if (arr[neighbor] == arr[node]) {
                            return false; 
                        }
                    }
                }
            }
        }
        
        return true;
    }
}