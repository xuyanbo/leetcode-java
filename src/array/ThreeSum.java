package array;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int length = nums.length;

        for(int i = 0; i < length; ++i) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i + 1;
            int right = length - 1;

            int sum = -1 * nums[i];

            while(left < right) {
                if(nums[left] + nums[right] == sum) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
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

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> list = new ThreeSum().threeSum(nums);
        for(int i = 0; i < list.size(); ++i) {
            for(int j = 0; j < list.get(i).size(); ++j) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println(" ");
            System.out.println("******************");
        }
    }
}
