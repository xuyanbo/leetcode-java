package array;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        for(; i >= 0; --i) {
            if(digits[i] != 9) {
                digits[i] += 1;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if(i == -1) {
            int[] newdigits = new int[digits.length+1];
            newdigits[0] = 1;
            for(int j = 0; j < digits.length; ++j) {
                newdigits[j+1] = digits[j];
            }
            return newdigits;
        }

        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9,9,9};
        int[] result = new PlusOne().plusOne(digits);

        for(int i = 0; i < result.length; ++i) {
            System.out.print(result[i] + "  ");
        }
    }
}
