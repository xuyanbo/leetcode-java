package string;

public class AddBinary {
    public String addBinary(String a, String b) {
        int alen = a.length(), blen = b.length();
        int len = alen > blen ? alen:blen;
        int i = 0, upflag = 0, unitSum;
        String sum = "";

        while(i < len) {
            char achar = i < alen ? a.charAt(alen-i-1) : '0';
            char bchar = i < blen ? b.charAt(blen-i-1) : '0';
            unitSum = upflag + achar - '0' + bchar - '0';

            if(unitSum >= 2) {
                upflag = 1;
                unitSum -= 2;
            } else {
                upflag = 0;
            }

            sum = unitSum + sum;

            ++i;
        }
        if(upflag == 1) {
            sum = upflag + sum;
        }

        return sum;
    }

    public static void main(String[] args) {
        String result = new AddBinary().addBinary("1010", "1011");
        System.out.println(result);
    }
}
