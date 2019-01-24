package array;

public class TrappingRainWater {
    public int trap(int[] height) {
        int length = height.length;
        int maxIndex = 0;
        for(int i = 0; i < length; ++i) {
            if(height[i] >= height[maxIndex]) {
                maxIndex = i;
            }

        }

        int trap = 0;
        for(int i = 0, peak = 0; i < maxIndex; ++i) {
            if(height[i] > peak) peak = height[i];
            else trap += (peak - height[i]);
        }

        for(int i = length-1, top = 0; i > maxIndex; --i) {
            if(height[i] > top) top = height[i];
            else trap += (top - height[i]);
        }

        return trap;
    }

    public static void main(String[] args) {
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {2,8,5,5,6,1,7,4,5};

        int result = new TrappingRainWater().trap(height);
        System.out.println(result);
    }
}
