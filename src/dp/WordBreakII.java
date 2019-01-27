package dp;

import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();

        helper(s, wordDict, 0, new StringBuilder(), result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        return result;
    }

    public void helper(String s, List<String> wordDict, int start, StringBuilder sb, List<String> res) {
        if(start == s.length()) {
            res.add(new String(sb));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if(wordDict.contains(s.substring(start, i+1))) {
                int len = sb.length();
                sb.append(s, start, i+1);
                if(i < s.length()-1) sb.append(" ");

                helper(s, wordDict, i+1, sb, res);

                sb.delete(len, sb.length());
            }
        }
    }

    public List<String> wordBreakDFS(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<>());
    }

    public List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if(map.containsKey(s)) {
            return map.get(s);
        }

        LinkedList<String> res = new LinkedList<>();
        if(s.length() == 0) {
            res.add("");
            return res;
        }

        for (String word : wordDict) {
            if(s.startsWith(word)) {
                List<String> subList = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : subList) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);

        return res;
    }

    public List<String> wordBreakDP(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int maxLen = 0, minLen = Integer.MAX_VALUE;
        int n = s.length();
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (String str:wordDict){
            int len = str.length();
            maxLen = Math.max(maxLen, len);
            minLen = Math.min(minLen, len);
        }
        for (int i = minLen; i <= s.length(); i++){
            for (int j = i - maxLen > 0? i - maxLen : 0; j <= i - minLen; j++){
                if (dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        if (!dp[n]) {
            return new ArrayList<String>();
        }

        List<String>[] memo = new List[n + 1];
        memo[0] = new ArrayList<>();
        memo[0].add("");

        for (int i = 1; i <= n; i++) {
            memo[i] = new ArrayList<>();
            for (int j = Math.max(0, i - maxLen); j <= i - minLen; j++) {
                if (memo[j].size() > 0 && dict.contains(s.substring(j, i))) {
                    String word = s.substring(j, i);
                    for (String sub : memo[j]) {
                        if (sub.equals("")) {
                            memo[i].add(word);
                        } else {
                            memo[i].add(sub + " " + word);
                        }
                    }
                }
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //catsanddog
        list.add("cat");list.add("cats");list.add("and");list.add("sand");list.add("dog");
        //pineapplepenapple
//        list.add("apple");list.add("pen");list.add("applepen");
//        list.add("pine");list.add("pineapple");
//        list.add("cats");list.add("dog");list.add("sand");list.add("and");list.add("cat");
        //aaaaaaa
//        list.add("aaaa");list.add("aa");list.add("a");
        new WordBreakII().wordBreakDP("catsanddog", list);
    }
}
