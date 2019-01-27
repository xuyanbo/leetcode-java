package dp;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length, column = matrix[0].length;
        int[][] leftdp = new int[row][column];
        int[][] updp = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(matrix[i][j] == '0') {
                    leftdp[i][j] = 0;
                    updp[i][j] = 0;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println(new MaximalRectangle().maximalRectangle(matrix));
    }
}
