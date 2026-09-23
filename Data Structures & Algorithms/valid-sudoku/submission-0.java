class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j] != '.'){
                    char c = board[i][j];
                    board[i][j] = '.';
                    if(!solve(board, i, j, c)) return false;
                    board[i][j] = c;
                }
            }
        }
        return true;
    }

    public boolean solve(char[][] board, int row, int col, char ch){
        for(int i=0;i<9;i++){
            if(board[i][col] == ch) return false;
        }
        for(int j=0;j<9;j++){
            if(board[row][j] == ch) return false;
        }

        int startRow = row - row%3;
        int startCol = col - col%3;

        for(int i=startRow;i<startRow+3;i++){
            for(int j=startCol;j<startCol+3;j++){
                if(board[i][j] == ch) return false;
            }
        }
        return true;
    }
}