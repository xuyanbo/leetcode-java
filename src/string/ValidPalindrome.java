package string;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int length = s.length();
        if(length == 0 || length == 1) return true;

        int prevIndex = 0;
        int endIndex = length - 1;

        do {
            char cPrev = s.charAt(prevIndex);
            char cEnd = s.charAt(endIndex);
            if(!isNumAlpha(cPrev)) {
                prevIndex ++;
                continue;
            }
            if(!isNumAlpha(cEnd)) {
                endIndex--;
                continue;
            }
            if(cPrev == cEnd || (isAlpha(cPrev) && isAlpha(cEnd) && cPrev+32 == cEnd)
                    || (isAlpha(cPrev) && isAlpha(cEnd) && cPrev-32 == cEnd)) {
                prevIndex++;
                endIndex--;
            } else {
                return false;
            }
        } while(prevIndex < endIndex);

        return true;
    }

    public boolean isNumAlpha(char c) {
        if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
            return true;
        return false;
    }
    public boolean isAlpha(char c) {
        if(((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')))
            return true;
        return false;
    }

    public boolean anotherIsPalindrome(String s) {
        int length = s.length();
        if(length == 0 || length == 1) return true;

        char[] map = new char[256];
        for(int i = 0; i < 10; ++i) {
            map[i+'0'] = (char)(i+1);
        }

        for(int i = 0; i < 26; ++i) {
            map[i+'a'] = map[i+'A'] = (char)(i+11);
        }

        int start = 0, end = length - 1;

        while(start < end) {
            char schar = map[s.charAt(start)];
            char echar = map[s.charAt(end)];

            if(schar != 0 && echar != 0) {
                if(schar != echar) {
                    return false;
                }
                start++;
                end--;
            } else {
                if(schar == 0) {
                    start++;
                }
                if(echar == 0) {
                    end--;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "0P";
        boolean result = new ValidPalindrome().anotherIsPalindrome(s);

        System.out.println(result);
    }
}
