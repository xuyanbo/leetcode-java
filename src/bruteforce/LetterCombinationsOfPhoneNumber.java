package bruteforce;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    String[] digits2Letter = {" ", "", "abc", "def", "ghi", "jki", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if("".equals(digits)) return result;

        getCombinations(digits, 0, result, new StringBuilder());

        return result;
    }

    public void getCombinations(String digits, int pos, List<String> result, StringBuilder sb) {
        if(sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        if(pos < digits.length()) {
            String letters = digits2Letter[digits.charAt(pos)-48];

            for (int i = 0; i < letters.length(); i++) {
                sb.append(letters.charAt(i));
                getCombinations(digits, pos+1, result, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        List<String> result = new LetterCombinationsOfPhoneNumber().letterCombinations("13");

        for(String val:result) {
            System.out.println(val);
        }
    }
}
