package sort;


public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        new QuickSort().quicksort(nums, 0, nums.length-1);

        int num = 1;

        for (int i = 0; i < nums.length; i++) {
            if(num == nums[i]) {
                num++;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        int[] tokens = {1, 2, 3};

        new FirstMissingPositive().firstMissingPositive(tokens);
        for(int val:tokens) {
            System.out.println(val);
        }
    }
}
