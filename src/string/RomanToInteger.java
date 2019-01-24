package string;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        int num = 0;
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        for (int i = 0; i < s.length(); ) {
            if(i+1 < s.length() && map.get(s.substring(i, i+2)) != null) {
                num += map.get(s.substring(i, i+2));
                i += 2;
            } else {
                num += map.get(String.valueOf(s.charAt(i)));
                ++i;
            }

        }

        return num;
    }

    public static void main(String[] args) {
        int num = new RomanToInteger().romanToInt("MMCMXCIV");
        System.out.println(num);
    }
}
