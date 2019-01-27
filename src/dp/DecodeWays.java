package dp;

public class DecodeWays {
    // s =    1   1   0   1  0
    // dp= 0  1   2   3   4  5
    // i =>  i-1 >= 1
    public int numDecodings(String s) {
        if(s.length() ==0) return 0;
        int[] dp = new int[s.length()+1];
        dp[0]=1;

        if(s.charAt(0) > '0') {
            dp[1] = 1;
        }
//        for(int i = 2; i <= s.length(); i++){
//            if(s.charAt(i-1) >= '1') {
//                dp[i] = dp[i - 1];
//            }
//            int sum = Integer.parseInt(s.substring(i-2,i));
//            if(sum <= 26 && s.charAt(i-2) != '0') {
//                dp[i] += dp[i - 2];
//            }
//        }

        for (int i = 2; i <= s.length(); i++) {
            if(s.charAt(i-1) >= '1') dp[i] = dp[i-1];

            int first = s.charAt(i-2) - '0';
            int second = s.charAt(i-1) - '0';
            if(first == 1 || first == 2 && second <= 6) dp[i] += dp[i-2];
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        // 112 => 1  1  2 => 11 2 => 1 12
        // 12=> 1  2 => 12
        // 205 => 20 5
        // 11010 => 1 10 10
        // 1110 => 1 1 10 => 11 10
        // 1 2 3
        System.out.println(new DecodeWays().numDecodings("111010"));
    }
}
