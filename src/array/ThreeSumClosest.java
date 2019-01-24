package array;

import java.util.Arrays;

// 3Sum Closest
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int length = nums.length;
        int result = nums[0] + nums[1] + nums[length-1];

        for(int i = 0; i < length; ++i) {

            int left = i + 1;
            int right = length - 1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < target) {
                    left++;
                } else {
                    right--;
                }

                if(Math.abs(target - result) > Math.abs(target - sum)) {
                    result = sum;
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};

        int result = new ThreeSumClosest().threeSumClosest(nums, 1);

        System.out.println(result);
    }
}
