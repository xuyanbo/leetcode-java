package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if(i > pos && candidates[i-1] == candidates[i]) continue;
            list.add(candidates[i]);
            combinationDFS(candidates, target-candidates[i], i+1, list, res);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};

        List<List<Integer>> res = new CombinationSumII().combinationSum2(candidates, 5);

        for(List<Integer> list: res) {
            for(int val : list) {
                System.out.print(val + "  ");
            }
            System.out.println("  ");
        }
    }
}
