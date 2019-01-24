package greedy;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length-1;

        while(left < right) {
            max = Math.max(max, (right-left) * Math.min(height[left], height[right]));
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public int betterMaxArea(int[] height) {
        int res = 0, i = 0, j = height.length - 1;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            res = Math.max(res, h * (j - i));
            while (i < j && h == height[i]) ++i;
            while (i < j && h == height[j]) --j;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println(new ContainerWithMostWater().maxArea(height));
    }
}
