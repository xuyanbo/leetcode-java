package sort;

public class QuickSort {
    public void quicksort(int[] nums, int start, int end) {
        if(start > end) return;
        int i = start, j = end, index = nums[start];

        while(i < j) {
            while(i < j && nums[j] >= index) j--;
            if(i < j) nums[i++] = nums[j];

            while(i < j && nums[i] < index) i++;
            if(i < j) nums[j--] = nums[i];
        }

        nums[i] = index;
        quicksort(nums, start, i-1);
        quicksort(nums, i+1, end);
    }

    public static void main(String[] args) {
        //int[] tokens = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        int[] tokens = {1,2,2,1,3,1,0,4,0};

        new QuickSort().quicksort(tokens, 0, tokens.length-1);

        for(int val:tokens) {
            System.out.println(val);
        }
    }
}
