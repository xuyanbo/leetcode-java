package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        createSubsets(nums, 0, new ArrayList<>(), result);

        return result;
    }

    public void createSubsets(int[] nums, int start, List<Integer> sublist, List<List<Integer>> result) {
        result.add(new ArrayList<>(sublist));

        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i-1] == nums[i]) continue;

            sublist.add(nums[i]);
            createSubsets(nums, i + 1, sublist, result);

            sublist.remove(sublist.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] tokens = {1, 2, 2, 3};

        List<List<Integer>> result = new SubsetsII().subsetsWithDup(tokens);

        for(List<Integer> list:result) {
            for(int val : list) {
                System.out.print(val);
            }
            System.out.println("   ");
        }
    }
}
