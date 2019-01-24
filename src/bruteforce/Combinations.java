package bruteforce;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        getCombine(n, k, 1, new ArrayList<>(), result);

        return result;
    }

    public void getCombine(int n, int k, int start, List<Integer> list, List<List<Integer>> result) {
        if(list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            getCombine(n, k, i+1, list, result);
            list.remove(list.size()-1);
        }
    }



    public static void main(String[] args) {
        List<List<Integer>> result = new Combinations().combine(4, 2);

        for(List<Integer> list: result) {
            for(int val : list) {
                System.out.print(val + "   ");
            }
            System.out.println("  ");
        }
    }
}
