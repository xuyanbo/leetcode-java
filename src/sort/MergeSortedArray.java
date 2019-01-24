package sort;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1, i = m-1, j = n-1;

        for (; i >= 0 && j >= 0; ) {
            if(nums1[i] >= nums2[j]) {
                nums1[index] = nums1[i];
                i--;
            } else  {
                nums1[index] = nums2[j];
                j--;
            }
            index--;
        }

        if(j >= 0) {
            for(; j >=0 && index >= 0; j--, index--) {
                nums1[index] = nums2[j];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,7,0,0,0};
        int[] nums2 = {2,5,6};

        new MergeSortedArray().merge(nums1, 3, nums2, 3);
        for(int val:nums1) {
            System.out.println(val);
        }
    }
}
