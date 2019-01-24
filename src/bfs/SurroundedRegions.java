package bfs;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int row = board.length;
        int column = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if((i == 0 || i == row-1 || j == 0 || j == column-1) && board[i][j] == 'O') {
                    solveDFS(board, i, j);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == '$') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void solveDFS(char[][] board, int i, int j) {
        if(board[i][j] == 'O') {
            board[i][j] = '$';

            if(i > 0 && board[i-1][j] == 'O') {
                solveDFS(board, i-1, j);
            }
            if(j < board[i].length-1 && board[i][j+1] == 'O') {
                solveDFS(board, i, j+1);
            }
            if(i < board.length-1 && board[i+1][j] == 'O') {
                solveDFS(board, i+1, j);
            }
            if(j > 1 && board[i][j-1] == 'O') {
                solveDFS(board, i, j-1);
            }
        }

    }

    public static void main(String[] args) {
        char[][] board = {{'O', 'O'}, {'O', 'O'}};
//        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
//        char[][] board = {
//                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//                {'X', 'X', 'X', 'X', 'O', 'O', 'X', 'X'},
//                {'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X', 'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X', 'X', 'X', 'X', 'X'},
//                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
//        };

        new SurroundedRegions().solve(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("  ");
        }
    }
}
