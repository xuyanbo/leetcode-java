package search;


public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        bsearch(nums, 0, nums.length-1, target, result);

        return result;
    }

    public void bsearch(int[] nums, int start, int end, int target, int[] result) {
        if(start > end) return;

        int mid = start + (end - start) / 2;
        if(nums[mid] == target) {
            if(result[0] > mid || result[0] == -1) result[0] = mid;
            if(result[1] < mid || result[1] == -1) result[1] = mid;

            bsearch(nums, start, mid-1, target, result);
            bsearch(nums, mid+1, end, target, result);
        } else if(nums[mid] < target) {
            bsearch(nums, mid+1, end, target, result);
        } else if(nums[mid] > target) {
            bsearch(nums, start, mid-1, target, result);
        }
    }

    public static void main(String[] args) {
        int[] tokens = {5,7,7,8,8,10};

        int[] result = new FindFirstAndLastPositionOfElementInSortedArray().searchRange(tokens, 8);

        for(int val:result) {
            System.out.println(val);
        }
    }
}
