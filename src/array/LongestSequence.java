package array;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSequence {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new LinkedHashMap<>();
        for(int num: nums) map.put(num, false);

        int longest = 0;
        for(Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if(entry.getValue()) {
                continue;
            }

            int key = entry.getKey();
            entry.setValue(true);

            int bfe_index = 1;
            int aft_index = 1;
            while(true) {
                if(map.get(key - bfe_index) != null || map.get(key + aft_index) != null) {
                    if(map.get(key - bfe_index) != null) {
                        map.put(key-bfe_index, true);
                        ++bfe_index;
                    }
                    if(map.get(key + aft_index) != null) {
                        map.put(key+aft_index, true);
                        ++aft_index;
                    }
                } else {
                    break;
                }
            }

            longest = Math.max(longest, bfe_index+aft_index-1);
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 5};

        int length = new LongestSequence().longestConsecutive(nums);

        System.out.println("============");
        System.out.println(length);
    }
}
