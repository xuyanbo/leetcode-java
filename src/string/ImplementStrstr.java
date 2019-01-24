package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImplementStrstr {
    public int strStr(String haystack, String needle) {
        int i = 0, j = 0;

        for(; i < haystack.length() && j < needle.length(); ) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if(j == needle.length()) {
            return i - j;
        }

        return -1;
    }

    public int simpleStrStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }

        return haystack.indexOf(needle);
    }

    public Integer[] getNext(String needle) {
        List<Integer> nextList = new ArrayList<>();
        nextList.add(-1);

        int len = needle.length();
        int j = 0;
        int k = -1;
        while(j < len-1) {
            if(k == -1 || needle.charAt(j) == needle.charAt(k)) {
                ++k;
                ++j;
                nextList.add(k);
            } else {
                k = nextList.get(k);
            }
        }

        return nextList.toArray(new Integer[nextList.size()]);
    }

    public int kmpSearch(String haystack, String needle) {
        Integer[] next = getNext(needle);
        int slen = haystack.length();
        int plen = needle.length();
        int i = 0, j = 0;

        while(i < slen && j < plen) {
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }

        if(j == plen) {
            return i-j;
        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";

        int result = new ImplementStrstr().kmpSearch(haystack, needle);

        System.out.println(result);
    }
}
