package array;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean row = false;
        boolean column = false;
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(matrix[i][j] == 0) {
                    if(i != 0 && j != 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    } else if(i == 0 && j == 0){
                        row = true;
                        column = true;
                    } else if(i == 0) {
                        row = true;
                    } else {
                        column = true;
                    }
                }
            }
        }

        for(int j = n-1; j > 0; --j) {
            if(matrix[0][j] == 0) {
                for(int i = 1; i < m; ++i) {
                    matrix[i][j] = 0;
                }
            } else if(row) {
                matrix[0][j] = 0;
            }
        }

        for(int i = m-1; i > 0; --i) {
            if(matrix[i][0] == 0) {
                for(int j = 1; j < n; ++j) {
                    matrix[i][j] = 0;
                }
            } else if(column) {
                matrix[i][0] = 0;
            }
        }

        if(row || column) {
            matrix[0][0] = 0;
        }

    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 0}};
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new SetMatrixZeroes().setZeroes(matrix);

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
