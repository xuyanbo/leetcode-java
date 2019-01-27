package dp;

public class PalindromePartitioningII {
    public int minCut(String s) {
        int length = s.length();
        boolean[][] P = new boolean[length][length];
        int[] dp = new int[length+1];
        for (int i = 0; i <= length; ++i) {
            dp[i] = length - i - 1;
        }

        for (int i = length - 1; i >= 0; --i) {
            for (int j = i; j < length; ++j) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || P[i + 1][j - 1])) {
                    P[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioningII().minCut("bb"));
    }
}
