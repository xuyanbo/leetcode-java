package dfs;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] path = new int[obstacleGrid.length][obstacleGrid[0].length];
        path[0][0] = 1;

        return pathDFS(obstacleGrid.length-1, obstacleGrid[0].length-1, path, obstacleGrid);
    }

    public int pathDFS(int x, int y, int[][] path, int[][] grid) {
        if(x < 0 || y < 0 || grid[x][y] == 1) return 0;
        if(x == 0 && y == 0) return path[0][0];

        if(path[x][y] > 0) {
            return path[x][y];
        } else {
            return path[x][y] = pathDFS(x-1, y, path, grid) + pathDFS(x, y-1, path, grid);
        }
    }

    public int betterUniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid[0].length == 0) return 0;
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;

        obstacleGrid[0][0] = 1;

        for (int i = 1; i < column; i++) {
            if(obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1] == 1) {
                obstacleGrid[0][i] = 1;
            } else {
                obstacleGrid[0][i] = 0;
            }
        }

        for (int i = 1; i < row; i++) {
            if(obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0]== 1) {
                obstacleGrid[i][0] = 1;
            } else {
                obstacleGrid[i][0] = 0;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if(obstacleGrid[i][j] != 1) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[row-1][column-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1}};

        System.out.println(new UniquePathsII().betterUniquePathsWithObstacles(grid));
    }
}
