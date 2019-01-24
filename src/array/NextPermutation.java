package array;

public class NextPermutation {
    // 287946531 => 2879 5 6431
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2) return;

        int length = nums.length;

        int temp ;
        boolean flag = true;
        for(int i = length-2; i >= 0; --i) {
           if(nums[i] < nums[i+1] || i == 0) {
                for(int j = length-1; j > i; --j) {
                    if(nums[j] > nums[i]) {
                        temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        flag = false;
                        break;
                    }
                }
                int left = i + 1;
                int right = length -1;
                if(i == 0 && flag) {
                    left = 0;
                }

                for(; left < right; ++left, --right) {
                    temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
                break;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2};

        new NextPermutation().nextPermutation(nums);
        System.out.println("****************");
        for(int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i]);
        }
    }
}
