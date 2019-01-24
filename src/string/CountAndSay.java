package string;

public class CountAndSay {
    public String countAndSay(int n) {
        if(n == 0) return "";

        String result = "1", tmp = "";
        int cnt = 0;

        while(--n > 0) {
            for(int i =  0; i < result.length(); ++i) {
                if(i == 0 || result.charAt(i) == result.charAt(i-1)) {
                    cnt++;
                } else {
                    tmp += (String.valueOf(cnt) + String.valueOf(result.charAt(i-1)));
                    cnt = 1;
                }

                if(i == result.length()-1) {
                    tmp += (String.valueOf(cnt) + String.valueOf(result.charAt(i)));
                }
            }
            result = tmp;
            tmp = "";
            cnt = 0;
        }

        return result;
    }

    public static void main(String[] args) {
        String result = new CountAndSay().countAndSay(5);
        System.out.println(result);
    }
}
