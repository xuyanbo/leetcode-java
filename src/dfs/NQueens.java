package dfs;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        nQueensDFS(n, 0, new ArrayList<>(), res);

        return res;
    }

    public void nQueensDFS(int n, int x, List<String> list, List<List<String>> result) {
        if(x == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        List<String> queensList = getQueens(n, list);

        if(queensList.size() == 0) {
            return;
        }

        for (int i = 0; i < queensList.size(); i++) {
            list.add(queensList.get(i));
            nQueensDFS(n, x+1, list, result);
            list.remove(list.size()-1);
        }
    }

    public List<String> getQueens(int n, List<String> list) {
        List<String> queensList = new ArrayList<>();

        if(list == null || list.size() == 0) {
            for (int i = 0; i < n; i++) {
                queensList.add(queenFormat(n, i));
            }
        } else {
            for (int i = 0; i < n; i++) {
                boolean lu = true, u= true, ru = true;

                for (int j = list.size()-1, k = 0; j >= 0; j--, k++) {
                    if(i-k-1 >= 0 && list.get(j).charAt(i-k-1) == 'Q') {
                        lu = false;
                        break;
                    }
                    if(list.get(j).charAt(i) == 'Q') {
                        u = false;
                        break;
                    }
                    if(i+k+1 < n && list.get(j).charAt(i+k+1) == 'Q') {
                        ru = false;
                        break;
                    }
                }
                if(lu && u && ru) {
                    queensList.add(queenFormat(n, i));
                }
            }
        }

        return queensList;
    }

    public String queenFormat(int n, int i) {
        StringBuilder sb =  new StringBuilder();
        for (int j = 0; j < n; j++) {
            if(j == i) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        List<List<String>> res = new NQueens().solveNQueens(4);

        for(List<String> list: res) {
            for(String val: list) {
                System.out.println(val);
            }
            System.out.println("======================");
        }
    }
}
