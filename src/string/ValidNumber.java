package string;

public class ValidNumber {
    public boolean isNumber(String s) {
        int state = 1;

        for (int i = 0; i < s.length(); i++) {
            switch (state) {
                case 1:
                    if(s.charAt(i) == ' ') state = 1;
                    else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') state = 3;
                    else if(s.charAt(i) == '-' || s.charAt(i) == '+') state = 2;
                    else if(s.charAt(i) == '.') state = 4;
                    else return false;
                    break;
                case 2:
                    if(s.charAt(i) >= '0' && s.charAt(i) <= '9') state = 3;
                    else if(s.charAt(i) == '.') state = 4;
                    else return false;
                    break;
                case 3:
                    if(s.charAt(i) >= '0' && s.charAt(i) <= '9') state = 3;
                    else if(s.charAt(i) == 'e') state = 6;
                    else if(s.charAt(i) == '.') state = 5;
                    else if(s.charAt(i) == ' ') state = 9;
                    else return false;
                    break;
                case 4:
                    if(s.charAt(i) >= '0' && s.charAt(i) <= '9') state = 5;
                    else return false;
                    break;
                case 5:
                    if(s.charAt(i) >= '0' && s.charAt(i) <= '9') state = 5;
                    else if(s.charAt(i) == 'e') state = 6;
                    else if(s.charAt(i) == ' ') state = 9;
                    else return false;
                    break;
                case 6:
                    if(s.charAt(i) >= '0' && s.charAt(i) <= '9') state = 8;
                    else if(s.charAt(i) == '-' || s.charAt(i) == '+') state = 7;
                    else return false;
                    break;
                case 7:
                    if(s.charAt(i) >= '0' && s.charAt(i) <= '9') state = 8;
                    else return false;
                    break;
                case 8:
                    if(s.charAt(i) >= '0' && s.charAt(i) <= '9') state = 8;
                    else if(s.charAt(i) == ' ') state = 9;
                    else return false;
                    break;
                case 9:
                    if(s.charAt(i) == ' ') state = 9;
                    else return false;
                    break;
            }
        }

        return state == 3 || state == 5 || state == 8 || state == 9;
    }

    public boolean betterIsNumber(String s) {
        if(s == null || s.length() == 0) return false;
        s = s.trim();

        boolean eflag = false, numflag = false, pointflag = false, numberAfterE = false;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e') return false;
            } else if(s.charAt(i) == 'e') {
                if(eflag || !numflag) return false;
                eflag = true;
                numberAfterE = false;
            } else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numflag = true;
                numberAfterE = true;
            } else if(s.charAt(i) == '.') {
                if(eflag || pointflag) return false;
                pointflag = true;
            } else {
                return false;
            }
        }

        return numflag && numberAfterE;
    }

    public static void main(String[] args) {
        boolean result = new ValidNumber().isNumber("4e+");

        System.out.println(result);
    }
}
