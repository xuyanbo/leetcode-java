package array;


public class MedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int arrLen = nums1.length + nums2.length;

        if(arrLen % 2 == 0) {
            int value = kth_min_num(nums1, 0, nums2, 0, arrLen/2);
            System.out.println("value=" + value);
            int value2 = kth_min_num(nums1, 0, nums2, 0, arrLen/2+1);
            System.out.println("value2=" + value2);

            return (value+value2)/2.0;
        }

        return kth_min_num(nums1, 0, nums2, 0, arrLen/2+1);
    }

    public int kth_min_num(int[] nums1, int start1, int[] nums2, int start2, int k) {
        System.out.println("**************");
        System.out.println("start1=" + start1);
        System.out.println("start2=" + start2);
        System.out.println("k=" + k);
        for(int i = start1; i < nums1.length; ++i) {
            System.out.print(nums1[i]);
            System.out.print(" ");
        }
        System.out.println(" ");
        for(int i = start2; i < nums2.length; ++i) {
            System.out.print(nums2[i]);
            System.out.print(" ");
        }
        System.out.println(" ");

        if(nums1.length == 0) {
            return nums2[k-1];
        }
        if(nums2.length == 0) {
            return nums1[k-1];
        }

        if(start1 > nums1.length-1) return nums2[start2+k-1];
        if(start2 > nums2.length-1) return nums1[start1+k-1];

        int index = k;
        if(nums1.length-start1 < index/2) {
            index = nums1.length - start1;
        }
        if(nums2.length-start2 < (index - index/2)) {
            index = nums2.length - start2;
        }

        System.out.println("index=" + index);

        if(k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int index1 = index/2;
        int index2 = index - index1;
        if(index == 1) {
            index1 = 1;
            index2 = 1;
        }

        if((nums1[start1 + index1 - 1] == nums2[start2 + index2 - 1]) && (index1 + index2 == k)) {
            return nums1[start1 + index/2 - 1];
        } else if(nums1[start1 + index1 - 1] > nums2[start2 + index2 - 1]) {
            return kth_min_num(nums1, start1, nums2, start2+index2, k-index2);
        }

        return kth_min_num(nums1, start1+index1, nums2, start2, k-index1);
    }

//    [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22]
//[0,6]
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
        int[] nums2 = {0,6};

        double length = new MedianSortedArrays().findMedianSortedArrays(nums1, nums2);

        System.out.println("==========");
        System.out.println(length);
    }
}
