package dfs;

public class UniquePaths {
    int count = 0;
    public int uniquePaths(int m, int n) {
        pathsDFS(m, n, 1, 1);

        return count;
    }

    public void pathsDFS(int m, int n, int i, int j) {
        if(i == m && j == n) {
            count++;
            return;
        }

        if(i < m) pathsDFS(m, n, i+1, j);
        if(j < n) pathsDFS(m, n, i, j+1);
    }

    public int bestUniquePaths(int m, int n) {
        int N = n + m - 2;// how much steps we need to do
        int k = m - 1; // number of steps that need to go down
        double res = 1;
        // here we calculate the total possible path number
        // Combination(N, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
        for (int i = 1; i <= k; i++) {
            res = res * (N - k + i) / i;
        }

        return (int)res;
    }


    public int betterUniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        path[0][0] = 1;

        return dfs(m-1, n-1, path);
    }

    public int dfs(int i, int j, int[][] path) {
        if(i < 0 || j < 0) return 0;
        if(i == 0 && j == 0) return path[0][0];

        if(path[i][j] > 0) {
            return path[i][j];
        } else {
            return path[i][j] = dfs(i-1, j, path) + dfs(i, j-1, path);
        }
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().betterUniquePaths(51, 9));
    }
}
