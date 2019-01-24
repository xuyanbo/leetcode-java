package string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman {
    public String intToRoman(int num) {
        String roman = "";
        if(num == 0) return "";

        HashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        if(num < 4) {
            while(num-- > 0) {
                roman += 'I';
            }
        }

        for(Map.Entry<Integer, String> entry: map.entrySet()) {
            if(num / entry.getKey() != 0) {
                int cnt = num / entry.getKey();
                while(cnt-- > 0) {
                    roman += entry.getValue();
                }

                num = num % entry.getKey();
            }
        }

        return roman;
    }

    public static void main(String[] args) {
        String result = new IntegerToRoman().intToRoman(2994);
        System.out.println(result);
    }
}
