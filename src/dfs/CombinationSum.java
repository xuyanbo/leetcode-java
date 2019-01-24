package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        combinationDFS(candidates, target, 0, new ArrayList<>(), res);

        return res;
    }

    public void combinationDFS(int[] candidates, int target, int pos, List<Integer> list, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            if(candidates[i] > target) break;
            list.add(candidates[i]);
            combinationDFS(candidates, target-candidates[i], i, list, res);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};

        List<List<Integer>> res = new CombinationSum().combinationSum(candidates, 8);

        for(List<Integer> list: res) {
            for(int val : list) {
                System.out.print(val + "  ");
            }
            System.out.println("  ");
        }
    }
}
