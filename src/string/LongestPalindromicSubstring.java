package string;

public class LongestPalindromicSubstring {


    public String longestPalindrome(String s) {
        int len = s.length(), i = 0;

        StringBuilder new_sbuilder = new StringBuilder("@");
        while(i < len) {
            new_sbuilder.append('#').append(s.charAt(i));
            ++i;
        }
        new_sbuilder.append('#').append('?');

        String newStr = new_sbuilder.toString();
        int newLen = newStr.length(), id = 0, mx = 0, maxLen = -1, maxIndex=0;
        int[] p = new int[newLen];

        for(i = 1; i < newLen; ++i) {
            if(i < mx) {
                p[i] = Math.min(p[2 * id - i], mx - i);
            } else {
                p[i] = 1;
            }

            while (i-p[i] >= 0 && i+p[i] < newLen && newStr.charAt(i - p[i]) == newStr.charAt(i + p[i])) {
                p[i]++;
            }

            if (mx < i + p[i]) {
                id = i;
                mx = i + p[i];
            }

            if(maxLen < p[i]-1) {
                maxLen = p[i] - 1;
                maxIndex = i;
            }
        }

        int index = (maxIndex - 1 - maxLen)/2;
        return s.substring(index, index+maxLen);
    }

    public static void main(String[] args) {
        String result = new LongestPalindromicSubstring().longestPalindrome("babad");
        System.out.println(result);
    }
}
