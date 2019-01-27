package dp;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) return false;
        boolean result = false;
        int[] indices = new int[s.length()];
        int index = 0, start = 0;

        for (int i = 0; i < s.length(); i++) {
            indices[index] = start;
            result = false;
            for (int j = index; j >= 0; j--) {
                if(wordDict.contains(s.substring(indices[j], i+1))) {
                    index++;
                    start = i+1;
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //list.add("cats");list.add("dog");list.add("sand");list.add("and");list.add("cat");
        //list.add("aaaa");list.add("aaa");
        list.add("go");list.add("goal");list.add("goals");list.add("special");
        Long start = System.currentTimeMillis();
        System.out.println(new WordBreak().wordBreak("goalspecial", list));
        System.out.println("cost time=" + (System.currentTimeMillis() - start));
    }
}
