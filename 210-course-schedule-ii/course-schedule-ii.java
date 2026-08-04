class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int prerequisite[] : prerequisites){
            adjList.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0 ; i < numCourses; i++){
            if (inDegree[i] == 0) queue.add(i);
        }
        int[] ans = new int[numCourses];
        int count = 0;
        while(!queue.isEmpty()){
            int top = queue.poll();
            ans[count++] = top;
            for(int neighbour : adjList.get(top)){
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) queue.add(neighbour);
            }
        }

        if (count == numCourses) {
            return ans;
        } else {
            return new int[0]; 
        }
    }
}