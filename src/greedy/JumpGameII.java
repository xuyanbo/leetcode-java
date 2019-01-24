package greedy;

public class JumpGameII {
    public int jump(int[] nums) {
        int step = 0, last = 0, cur = 0;

        for (int i = 0; i < nums.length; i++) {
            if(i > last) {
                last = cur;
                ++step;
            }

            cur = Math.max(nums[i]+i, cur);
        }

        return step;
    }

    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
//        int[] nums = {2,2,1,1,4};
//        int[] nums = {0};
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};

        System.out.println(new JumpGameII().jump(nums));
    }
}
