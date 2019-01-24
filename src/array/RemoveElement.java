package array;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {

        int length = nums.length;
        int index = 0;
        for(int i = 0; i < length; ++i) {
            if(nums[i] == val) continue;
            nums[index++] = nums[i];
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        int result = new RemoveElement().removeElement(nums, val);

        System.out.println(result);
    }
}
