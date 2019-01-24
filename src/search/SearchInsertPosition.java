package search;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= target) {
                return i;
            }
        }

        return nums.length;
    }

    public static void main(String[] args) {
        int[] tokens = {1,3,5,6};

        System.out.println(new SearchInsertPosition().searchInsert(tokens, 0));
    }
}
