package stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if(s.charAt(i) == '}' && (stack.empty() || stack.pop() != '{')) {
                return false;
            } else if(s.charAt(i) == ')' && (stack.empty() || stack.pop() != '(')) {
                return false;
            } else if(s.charAt(i) == ']' && (stack.empty() || stack.pop() != '[')) {
                return false;
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        boolean result = new ValidParentheses().isValid("([)]");
        System.out.println(result);
    }
}
