package greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;

        return jumpGreedy(nums, 0, nums.length);
    }

    public boolean jumpGreedy(int[] nums, int index, int length) {
        if(length == 0 || (length == 1 && index == nums.length-1)) return true;
        if(index > nums.length-1) return false;

        boolean res;
        for(int i = nums[index]; i >= 0; i--) {
            if(i == length) {
                return true;
            } else if(i < nums.length && i > 0) {
                res = jumpGreedy(nums, index + i, length-i);
                if(res) return true;
            }
        }

        return false;
    }


    public boolean betterCanJump(int[] nums) {
        int max = 0;

        for(int i = 0; i < nums.length;i++){
            if(i > max) {return false;}
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }

    public boolean bestCanJump(int[] nums) {
        int len = nums.length;
        int last = len-1;

        for(int i = len - 2; i >= 0; i--) {
            if(nums[i] + i >= last)
                last = i;
        }
        return last == 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
//        int[] nums = {2,3,1,1,4};
//        int[] nums = {0};
//        int[] nums = {1, 2};
//        int[] nums = {2, 0};

        System.out.println(new JumpGame().bestCanJump(nums));
    }
}
