package array;

public class Search {
    //Search in Rotated Sorted Array
    public int search(int[] nums, int target) {

        int first = 0;
        int last = nums.length;

        while(first != last) {
            int mid = first + (last-first) / 2;

            if(nums[mid] == target) {
                return mid;
            } else {
                if(nums[mid] > nums[first]) {
                    if(target < nums[mid] && target >= nums[first]) {
                        last = mid;
                    } else {
                        first = mid;
                    }
                } else {
                    if(target > nums[mid] && target <= nums[last-1]) {
                        first = mid;
                    } else {
                        last = mid;
                    }

                }
            }
        }

        return -1;
    }

    //Search in Rotated Sorted Array II
    public boolean search_2(int[] nums, int target) {
        int first = 0;
        int last = nums.length;

        while(first != last) {
            int mid = first + (last-first) / 2;

            if(nums[mid] == target) {
                return true;
            } else {
                if(nums[mid] > nums[first]) {
                    if(target < nums[mid] && target >= nums[first]) {
                        last = mid;
                    } else {
                        first = mid;
                    }
                } else if(nums[mid] < nums[first]){
                    if(target > nums[mid] && target <= nums[last-1]) {
                        first = mid;
                    } else {
                        last = mid;
                    }

                } else {
                    first++;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        boolean length = new Search().search_2(nums, 3);

        System.out.println("==========");
        System.out.println(length);
    }
}
