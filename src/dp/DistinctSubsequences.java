package dp;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int row = t.length(), column = s.length();
        if(row == 0 || column == 0) return 0;
        int[][] dp = new int[row][column];

        dp[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
        for (int i = 1; i < column; i++) {
            if(t.charAt(0) == s.charAt(i)) {
                dp[0][i] = dp[0][i-1] + 1;
            } else {
                dp[0][i] = dp[0][i-1];
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = i; j < column; j++) {
                if(s.charAt(j) == t.charAt(i)) {
                    if(i != j) {
                        dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                    } else {
                        dp[i][j] = dp[i-1][j-1];
                    }
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[row-1][column-1];
    }

    public static void main(String[] args) {
        System.out.println(new DistinctSubsequences().numDistinct("babgbag", "bag"));
    }
}
