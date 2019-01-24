package bfs;

import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(new ArrayList<String>(){{add(beginWord);}});

        while(!queue.isEmpty()) {
            int qLenght = queue.size();

            for (int k = 0; k < qLenght; k++) {
                List<String> pollList = queue.poll();
                String lastWord = pollList.get(pollList.size()-1);
                for (int i = 0; i < lastWord.length(); i++) {
                    char[] array = lastWord.toCharArray();
                    for (int j = 0; j < 26; j++) {
                        array[i] = (char)('a'+j);
                        String tmp = String.valueOf(array);

                        if(wordSet.contains(tmp) && !pollList.contains(tmp)) {
                            List<String> tmpList = new ArrayList<>(pollList);
                            tmpList.add(tmp);

                            if(tmp.equals(endWord)) {
                                result.add(tmpList);
                            } else {
                                queue.offer(tmpList);
                            }
                        }
                    }
                }
            }
            if(!result.isEmpty()) {
                break;
            }
        }

        return result;
    }

    public List<List<String>> betterFindLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        set.add(beginWord);

        while(!set.isEmpty()) {
            Set<String> tmpSet = new HashSet<>();

            for(String cur: set) {
                visited.add(cur);
                for(String next: getNexts(cur, wordSet)) {
                    if(visited.contains(next) || set.contains(next)) {
                        continue;
                    }
                    if(!map.containsKey(cur)) {
                        map.put(cur, new ArrayList<>());
                    }
                    map.get(cur).add(next);
                    tmpSet.add(next);
                }
            }
            set = tmpSet;
        }

        List<String> path = new ArrayList<>();
        path.add(beginWord);

        findLadders(beginWord, endWord, map, result, path);

        return result;
    }

    public void findLadders(String beginWord, String endWord, Map<String, List<String>> map, List<List<String>> result, List<String> path) {
        if(beginWord.equals(endWord)) {
            result.add(new ArrayList<>(path));
        }
        if(!map.containsKey(beginWord)) {
            return;
        }

        for(String next: map.get(beginWord)) {
            path.add(next);
            findLadders(next, endWord, map, result, path);
            path.remove(path.size()-1);
        }
    }

    public List<String> getNexts(String cur, Set<String> wordSet) {
        List<String> result = new ArrayList<>();
        char[] chars = cur.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) {
                    continue;
                }
                chars[i] = c;
                String next = new String(chars);
                if (wordSet.contains(next)) {
                    result.add(next);
                }
            }
            chars[i] = old;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] tokens = {"ted","tex","red","tax","tad","den","rex","pee"};

        List<List<String>> result = new WordLadderII().betterFindLadders("red", "tax", Arrays.asList(tokens));
        for(List<String> list: result) {
            for(String val: list) {
                System.out.print(val + "  ");
            }
            System.out.println("  ");
        }
    }
}
