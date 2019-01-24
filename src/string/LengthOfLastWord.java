package string;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') {
                if(i > 0 && s.charAt(i-1) == ' ') {
                    count = 1;
                } else {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int result = new LengthOfLastWord().lengthOfLastWord("Hello a    ");
        System.out.println(result);
    }
}
