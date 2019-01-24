package dfs;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board == null || board[0].length == 0) return false;
        if(word == null) return true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0) &&
                        searchDFS(board, word, new boolean[board.length][board[0].length], i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean searchDFS(char[][] board, String word, boolean[][] visited, int row, int column, int index) {
        if(row >= board.length && column >= board[0].length) return false;
        if(index == word.length()) return true;
        boolean up = false, down = false, left = false, right = false;

        if(board[row][column] == word.charAt(index)) {
            visited[row][column] = true;

            if(row-1 >= 0 && !visited[row-1][column]) {
                up = searchDFS(board, word, visited, row-1, column, index+1);
            }
            if(row+1 < board.length && !visited[row+1][column]) {
                down = searchDFS(board, word, visited, row+1, column, index+1);
            }
            if(column-1 >= 0 && !visited[row][column-1]) {
                left = searchDFS(board, word, visited, row, column-1, index+1);
            }
            if(column+1 < board[0].length && !visited[row][column+1]) {
                right = searchDFS(board, word, visited, row, column+1, index+1);
            }

            if(up || down || left || right || index == word.length()-1) return true;

            visited[row][column] = false;
        }

        return false;
    }

    public boolean betterExist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(searchDFS(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean searchDFS(char[][] board, String word, int row, int column, int index) {
        if(index >= word.length()) return true;
        if(row < 0 || column < 0 || row >= board.length || column >= board[0].length) return false;

        if(board[row][column] == word.charAt(index++)) {
            char tmpc = board[row][column];
            board[row][column] = '#';

            boolean res = searchDFS(board, word, row-1, column, index)
                    || searchDFS(board, word, row+1, column, index)
                    || searchDFS(board, word, row, column-1, index)
                    || searchDFS(board, word, row, column+1, index);

            board[row][column] = tmpc;

            return res;
        }

        return false;
    }

    public static void main(String[] args) {
//        char[][] board = {
//                {'A','B','C','E'}
//                ,
//                {'S','F','C','S'},
//                {'A','D','E','E'}
//        };
        char[][] board = {{'a'}};

        System.out.println(new WordSearch().betterExist(board, "a"));
    }
}
