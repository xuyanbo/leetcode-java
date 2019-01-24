package bruteforce;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        createSubsets(nums, 0, new ArrayList<>(), result);

        return result;
    }

    public void createSubsets(int[] nums, int start, List<Integer> sublist, List<List<Integer>> result) {
        for (int i = start; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.addAll(sublist);
            list.add(nums[i]);
            result.add(list);

            createSubsets(nums, i+1, list, result);
        }
    }

    public static void main(String[] args) {
        int[] tokens = {1, 2, 3};

        List<List<Integer>> result = new Subsets().subsets(tokens);
        System.out.println(result.size());

        for(List<Integer> list:result) {
            for(int val : list) {
                System.out.print(val);
            }
            System.out.println("   ");
        }
    }
}