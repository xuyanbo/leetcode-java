package stack;

public class LargestRectangleInHistogram {
    public int largestRectangLeArea(int[] heights) {

        int min_val = heights[0], max_val = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if(min_val > heights[i]) {
                min_val = heights[i];
            }
            if(max_val < heights[i]) {
                max_val = heights[i];
            }


        }

        return max_val;
    }
}
