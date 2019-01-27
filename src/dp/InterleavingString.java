package dp;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if(len1 + len2 != len3) return false;
        if(len1 == 0) {
            if(s2.equals(s3)) return true;
            else return false;
        }
        if(len2 == 0) {
            if(s1.equals(s3)) return true;
            else return false;
        }
        
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for (int i = 1; i < len1+1; i++) {
            if(s1.charAt(i-1) == s3.charAt(i-1)) {
                dp[i][0] = dp[i-1][0];
            }
        }

        for (int i = 1; i < len2+1; i++) {
            if(s2.charAt(i-1) == s3.charAt(i-1)) {
                dp[0][i] = dp[0][i-1];
            }
        }

        for (int i = 1; i < len1+1; i++) {
            for (int j = 1; j < len2+1; j++) {
                char c = s3.charAt(i+j-1);
                if(c == s1.charAt(i-1) && dp[i-1][j]) dp[i][j] = true;
                if(c == s2.charAt(j-1) && dp[i][j-1]) dp[i][j] = true;
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
