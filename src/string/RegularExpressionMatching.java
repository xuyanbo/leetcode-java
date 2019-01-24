package string;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0) return s.length() == 0;

        if(p.length() == 1 || p.charAt(1) != '*') {
            if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0))) {
                return false;
            }
            return isMatch(s.substring(1), p.substring(1));
        } else {
            int len = s.length();

            int i = -1;

            while(i < len && (i < 0 || p.charAt(0) == '.' || s.charAt(i) == p.charAt(0))) {
                if(isMatch(s.substring(i+1), p.substring(2))) {
                    return true;
                }
                ++i;
            }

            return false;
        }
    }

    public boolean betterIsMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }

        for(int i = 1; i < dp.length; ++i) {
            for(int j = 1; j < dp[0].length; ++j) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1) == '*') {
                    if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') {
                        dp[i][j] = dp[i][j-1] || dp[i-1][j] || dp[i][j-2];
                    } else {
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        boolean result = new RegularExpressionMatching().betterIsMatch("mississippi", "mis*is*p*.");
        System.out.println(result);
    }
}
