package string;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";

        for(int i = 0; i < strs[0].length(); i++) {
            for(int j = 1; j < strs.length; j++) {
                if((i < strs[j].length() && strs[0].charAt(i) != strs[j].charAt(i))
                        || (i == strs[j].length())) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {"abc", "abcd"};
        String result = new LongestCommonPrefix().longestCommonPrefix(strs);

        System.out.println(result);
    }
}
