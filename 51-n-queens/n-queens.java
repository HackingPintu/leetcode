class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> list = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        solve(list, board, n, 0);

        return list;
    }


    public void solve(List<List<String>> list, char[][] board, int n, int col){
        if(col == n){
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            list.add(temp);
            return;
        }

        for(int row = 0; row < n; row++){
            if(isSafe(row , col, n, board)){
                board[row][col] = 'Q';         
                
                solve(list, board, n, col + 1); 
               
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(int row, int col, int n, char[][] board){
        int duprow = row;
        int dupcol = col;

        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;

            row--;
            col--;
        }

        row = duprow;
        col = dupcol;

        while(col >= 0){
            if(board[row][col] == 'Q') return false;

            col--;
        }

        col = dupcol;

        while(row < n && col >= 0){
            if(board[row][col] == 'Q') return false;

            row++;
            col--;
        }

        return true;
    }
}