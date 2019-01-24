package string;

public class StringToInteger {
    public int myAtoi(String str) {
        int length = str.length();
        int result = 0, i = 0;
        boolean sign = true;

        while(i < length && str.charAt(i) == ' ') i++;

        if(i < length) {
            if(str.charAt(i) == '+') {
                i++;
            } else if(str.charAt(i) == '-') {
                sign = false;
                i++;
            }
        }

        while(i < length) {

            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if(result > Integer.MAX_VALUE / 10 ||
                        (result == Integer.MAX_VALUE/10
                                && str.charAt(i) - 48 > Integer.MAX_VALUE%10)) {
                    return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                result = result * 10 + (str.charAt(i) - 48);

                ++i;
            } else {
                break;
            }
        }

        return sign ? result:result*(-1);
    }

    public static void main(String[] args) {
        int result = new StringToInteger().myAtoi("-91283472332");
        System.out.println(result);
    }
}
