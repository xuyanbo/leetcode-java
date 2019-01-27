package dp;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0 && word2.length() == 0) return 0;
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();

        int[][] dp = new int[word2.length()+1][word1.length()+1];

        for (int i = 0; i < word2.length()+1; i++) dp[i][0] = i;
        for (int i = 0; i < word1.length()+1; i++) dp[0][i] = i;

        for (int i = 1; i < word2.length()+1; i++) {
            for (int j = 1; j < word1.length()+1; j++) {
                if(word2.charAt(i-1) == word1.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[word2.length()][word1.length()];
    }

    public static void main(String[] args) {
        new EditDistance().minDistance("intention", "execution");
    }
}
