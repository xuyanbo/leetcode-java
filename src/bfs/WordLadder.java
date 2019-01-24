package bfs;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = 1;
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while(!queue.isEmpty()) {
            int qLenght = queue.size();

            for (int k = 0; k < qLenght; k++) {
                String pollWord = queue.poll();
                for (int i = 0; i < pollWord.length(); i++) {
                    char[] array = pollWord.toCharArray();
                    for (int j = 0; j < 26; j++) {
                        array[i] = (char)('a'+j);
                        String tmp = String.valueOf(array);
                        if(wordSet.contains(tmp)) {
                            if(tmp.equals(endWord)) return length+1;
                            queue.offer(tmp);
                            wordSet.remove(tmp);
                        }
                    }
                }
            }
            length++;
        }

        return 0;
    }

    public static void main(String[] args) {
        String[] tokens = {"hot","dot","dog","lot","log","cog"};
//        String[] tokens = {"hot", "dog", "dot"};

        System.out.println(new WordLadder().ladderLength("hit", "cog", Arrays.asList(tokens)));
    }
}
