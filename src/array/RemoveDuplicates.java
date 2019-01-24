package array;

public class RemoveDuplicates {
    //Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) {return nums.length;}

        int index = 0;
        for(int i = 1; i < nums.length; ++i) {
            if(nums[index] == nums[i]) {

                continue;
            }

            index += 1;
            nums[index] = nums[i];
        }

        return index+1;
    }

    //Remove Duplicates from Sorted Array II
    public int removeDuplicates_2(int[] nums) {
        if(nums.length < 3) {return nums.length;}

        int index = 2;
        for(int i = 2; i < nums.length; ++i) {

            if(nums[i] != nums[index-2]) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int length = new RemoveDuplicates().removeDuplicates_2(nums);

        System.out.println("==========");
        System.out.println(length);

    }
}

