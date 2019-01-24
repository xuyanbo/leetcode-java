package dfs;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        partitionDFS(s, 0, new ArrayList<>(), result);

        return result;
    }

    public void partitionDFS(String s, int start, List<String> list, List<List<String>> result) {
        if(start == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if(isPalindrome(s, start, i)) {
                list.add(s.substring(start, i+1));

                partitionDFS(s, i+1, list, result);
                list.remove(list.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "aab";

        List<List<String>> result = new PalindromePartitioning().partition(s);

        for(List<String> list: result) {
            for(String str: list) {
                System.out.print(str + "  ");
            }
            System.out.println("  ");
        }
}
}
