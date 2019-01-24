package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 4Sum
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        int length = nums.length;

        for(int i = 0; i < length; ++i) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            for(int j = i+1; j < length; ++j) {

                if(j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }

                int left = j + 1;
                int right = length - 1;

                int sum = target - (nums[i] + nums[j]);

                while(left < right) {
                    if(nums[left] + nums[right] == sum) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if(nums[left] + nums[right] > sum) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return result;
    }

    public List<List<Integer>> betterFourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (len < 4)
            return res;

        Arrays.sort(nums);

        int max = nums[len - 1];
        if (4 * nums[0] > target || 4 * max < target)
            return res;

        int i, z;
        for (i = 0; i < len; i++) {
            z = nums[i];
            if (i > 0 && z == nums[i - 1])// avoid duplicate
                continue;
            if (z + 3 * max < target) // z is too small
                continue;
            if (4 * z > target) // z is too large
                break;
            if (4 * z == target) { // z is the boundary
                if (i + 3 < len && nums[i + 3] == z)
                    res.add(Arrays.asList(z, z, z, z));
                break;
            }

            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }

        return res;
    }

    public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                   int z1) {
        if (low + 1 >= high)
            return;

        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target)
            return;

        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            if (i > low && z == nums[i - 1]) // avoid duplicate
                continue;
            if (z + 2 * max < target) // z is too small
                continue;

            if (3 * z > target) // z is too large
                break;

            if (3 * z == target) { // z is the boundary
                if (i + 1 < high && nums[i + 2] == z)
                    fourSumList.add(Arrays.asList(z1, z, z, z));
                break;
            }

            twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
        }

    }

    public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                 int z1, int z2) {

        if (low >= high)
            return;

        if (2 * nums[low] > target || 2 * nums[high] < target)
            return;

        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

                x = nums[i];
                while (++i < j && x == nums[i]) // avoid duplicate
                    ;
                x = nums[j];
                while (i < --j && x == nums[j]) // avoid duplicate
                    ;
            }
            if (sum < target)
                i++;
            if (sum > target)
                j--;
        }
        return;
    }

    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};
        int target = -1;

//        int[] nums = {-3,-2,-1,0,0,1,2,3};
//        int target = 0;

//        int[] nums = {-1,-5,-5,-3,2,5,0,4};
//        int target = -7;

        List<List<Integer>> result = new FourSum().fourSum(nums, target);

        for(int i = 0; i < result.size(); ++i) {
            for(int j = 0; j < result.get(i).size(); ++j) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println("******************");
        }
    }
}
