package stack;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int slen = s.length(), last = -1, max_len = 0;

        for (int i = 0; i < slen; i++) {
            if(s.charAt(i) == ')') {
                if(stack.empty()) {
                    last = i;
                } else {
                    stack.pop();
                    if(stack.empty()) {
                        max_len = Math.max(max_len, i-last);
                    } else {
                        max_len = Math.max(max_len, i-stack.lastElement());
                    }
                }
            } else {
                stack.push(i);
            }
        }

        return max_len;
    }

    public static void main(String[] args) {
        //()((())
        //((()))
        //)()())
        int result = new LongestValidParentheses().longestValidParentheses("()((())");
        System.out.println(result);
    }
}
