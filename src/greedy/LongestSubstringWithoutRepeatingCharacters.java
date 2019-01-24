package greedy;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();

        int max = 0, pos = 0;

        for (int i = 1; i < s.length(); i++) {
            String sub = s.substring(pos, i);
            int index = sub.indexOf(s.charAt(i));
            if(index >= 0) {
                max = Math.max(max, i - pos);
                pos = pos + index + 1;
            } else if(i == s.length()-1) {
                max = Math.max(max, i - pos+1);
            }
        }

        return max;
    }

    public int betterLengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();

        int[] dict = new int[128];
        int max = 0, l = 0, r = 1;

        for (char c: s.toCharArray()) {
            l = Math.max(l, dict[c]);
            dict[c] = r;
            max = Math.max(max, r++ - l);
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().betterLengthOfLongestSubstring(s));
    }
}
