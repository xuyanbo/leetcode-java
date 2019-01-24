package array;

import java.util.Arrays;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);

        for(int i = 1; i < length; ) {
            if(nums[i-1] != nums[i]) {
                return nums[i-1];
            }
            i += 2;
        }

        return nums[length-1];
    }

    public int betterSigleNumber(int[] nums) {
        int sum = nums[0];

        for(int i = 1; i < nums.length; ++i) {
            sum ^= nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};

        int result = new SingleNumber().betterSigleNumber(nums);
        System.out.println(result);
    }
}
