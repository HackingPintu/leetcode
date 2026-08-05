class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] invocation : invocations){
            int u = invocation[0];
            int v = invocation[1];
            adj.get(u).add(v);
        }
        
        int[] sus = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        sus[k] = 1;
        while(!queue.isEmpty()){
            int top = queue.poll();
            for(int neighbour : adj.get(top)){
                if(sus[neighbour] == 0){
                    sus[neighbour] = 1;
                    queue.add(neighbour);
                }
              
            }
        }

       
        boolean canRemove = true;
        for (int i = 0; i < n; i++) {
            if (sus[i] == 0) { 
                for (int neighbour : adj.get(i)) {
                    if (sus[neighbour] == 1) { 
                        canRemove = false; 
                        break; 
                    }
                }
            }
            if (!canRemove) break;
        }

        List<Integer> list = new ArrayList<>();

        if (!canRemove) {
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (sus[i] == 0) {
                    list.add(i);
                }
            }
        }
        return list;
    }
}