package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        if(s == null || p == null) return result;
        int left = 0,right =0,count = p.length();
        int[] map = new int[256];
        char[] sc = s.toCharArray();
        for (char c : p.toCharArray()) map[c] ++;
        while (right < s.length()) {
            if (map[sc[right++]]-->=1) count --;
            if (count == 0) result.add(left);
            if (right - left == p.length() && map[sc[left++]]++ >=0) count++;
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = new FindAllAnagrams().findAnagrams("abab", "b");
        for(Integer r: result) {
            System.out.println(r);
        }
    }
}
