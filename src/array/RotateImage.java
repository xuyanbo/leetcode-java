package array;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int tmpValue, size = matrix.length-1;

        for(int i = 0; i < size; ++i) {
            for(int j = 0; (j+i) < size; ++j) {
                tmpValue = matrix[i][j];
                matrix[i][j] = matrix[size-j][size-i];
                matrix[size-j][size-i] = tmpValue;
            }
        }

        for(int i = 0; i < (size+1)/2; ++i) {
            for(int j = 0; j <= size; ++j) {
                tmpValue = matrix[i][j];
                matrix[i][j] = matrix[size-i][j];
                matrix[size-i][j] = tmpValue;
            }
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix = {{5, 1, 9,11}, {2, 4, 8,10}, {13, 3, 6, 7}, {15,14,12,16}};
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println(" ");
        }

        System.out.println("*******************"+ matrix.length);
        new RotateImage().rotate(matrix);
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println(" ");
        }
    }
}
