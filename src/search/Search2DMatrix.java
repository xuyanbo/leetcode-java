package search;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = 0;
        int column = matrix[0].length-1;
        for (; row < matrix.length; row++) {
            if(matrix[row][0] == target || matrix[row][column] == target) {
                return true;
            }

            if(matrix[row][0] < target && matrix[row][column] > target) {
                break;
            }
        }

        if(row == matrix.length) {
            return false;
        }

        return bsearch(matrix[row], 0, column, target);
    }

    public boolean bsearch(int[] rows, int start, int end, int target) {
        boolean leftBol = false;
        boolean rightBol = false;
        int mid = start + (end-start) / 2;

        if(rows[mid] == target) {
            return true;
        } else if(rows[mid] < target && start <= mid-1) {
            rightBol = bsearch(rows, mid+1, end, target);
        } else if(rows[mid] > target && mid+1 <= end) {
            leftBol = bsearch(rows, start, mid-1, target);
        }

        return leftBol || rightBol;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
//        int[][] matrix = {{1, 1}};

        System.out.println(new Search2DMatrix().searchMatrix(matrix, 5));
    }
}
