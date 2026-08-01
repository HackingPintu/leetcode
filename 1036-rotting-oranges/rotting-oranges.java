class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        int minutes = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }else if(grid[i][j] == 1) freshCount++;
            }
        }

        while(!queue.isEmpty() && freshCount > 0){
            int size = queue.size(); 
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll(); 
                int row = current[0];
                int col = current[1];
                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newRow < grid.length && 
                        newCol >= 0 && newCol < grid[0].length && 
                        grid[newRow][newCol] == 1) {
                            grid[newRow][newCol] = 2; 
                            freshCount--; 
                            queue.add(new int[]{newRow, newCol}); 
                    }
                }
            }
            minutes++;
        }
        return freshCount == 0 ? minutes : -1;
    }
}