package array;

import java.util.Arrays;

public class SingleNumberTwo {
    public int singleNumber(int[] nums) {
        int length = nums.length;

        Arrays.sort(nums);

        for(int i = 2; i < length; ) {
            if(nums[i-2] != nums[i-1] || nums[i-1] != nums[i]) {
                if(nums[i-2] != nums[i-1] && nums[i-1] == nums[i]) {
                    return nums[i-2];
                }
                if(nums[i-2] == nums[i-1]) {
                    return nums[i];
                }
            }

            i += 3;
        }

        return nums[length-1];
    }

    public int betterSingleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for(int i = 0; i < nums.length; ++i) {
            ones = ones^nums[i] & ~twos;
            twos = twos^nums[i] & ~ones;
        }

        return ones;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 4};

        int result = new SingleNumberTwo().betterSingleNumber(nums);

        System.out.println(result);
    }
}
