package array;

import java.util.HashMap;
import java.util.Map;

// Two Sum
public class TwoSum {
    public int[] forceTwoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; ++i) {
            for(int j = i + 1; j < nums.length; ++j) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public int[] hashTwoSum(int[] nums, int target) {
        HashMap<Integer, String> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i) {
            if(map.get(nums[i]) != null) {
                map.put(nums[i], map.get(nums[i]) + "_" + i);
            } else {
                map.put(nums[i], String.valueOf(i));
            }
        }

        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            int diff = target - entry.getKey();

            if(map.get(diff) != null) {
                if(diff == entry.getKey()) {
                    String indexStr = entry.getValue();

                    String[] indexs = indexStr.split("_");

                    if(indexs.length > 1) {
                        return new int[]{Integer.valueOf(indexs[0]), Integer.valueOf(indexs[1])};
                    }

                    return null;
                } else {
                    String[] index1s = entry.getValue().split("_");
                    String[] index2s = map.get(diff).split("_");

                    return new int[]{Integer.valueOf(index1s[0]), Integer.valueOf(index2s[0])};
                }
            }
        }

        return null;
    }

    public int[] betterHashTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        map.put(nums[0], 0);

        for(int i = 1; i < length; ++i) {
            if(map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};

        int[] indexs = new TwoSum().betterHashTwoSum(nums, 4);
        for(int i = 0; indexs != null && i < indexs.length; ++i) {
            System.out.println(indexs[i]);
        }
    }
}
