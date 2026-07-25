class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> list = new ArrayList<>();

        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }

        int[] side = new int[n];
        int[] upper = new int[2 * n - 1];
        int[] lower = new int[2 * n - 1];

        solve(list, board, n, 0, side, upper, lower);

        return list;

        
    }

    public void solve(List<List<String>> list, char[][] board, int n, int col, int[] side, int[] upper, int[] lower){
        if(col == n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                temp.add(new String(board[i]));
            }

            list.add(temp);
            return;
        }

        for(int row = 0; row < n; row++){
            if(side[row] == 0 && lower[col + row] == 0 && upper[n - 1 + col - row] == 0){
                board[row][col] = 'Q';
                side[row] = 1;
                lower[col + row] = 1; 
                upper[n - 1 + col - row] = 1;
                solve(list, board, n, col + 1, side, upper, lower);
                board[row][col] = '.';
                side[row] = 0;
                lower[col + row] = 0; 
                upper[n - 1 + col - row] = 0;

            }
        }
    }


}