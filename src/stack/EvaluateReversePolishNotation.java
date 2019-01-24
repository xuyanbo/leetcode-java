package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if("-".equals(token) || "+".equals(token) || "*".equals(token) || "/".equals(token)) {
                int num1 = stack.pop();
                int num2 = stack.pop();

                int result = 0;
                if("-".equals(token)) {
                    result = num2 - num1;
                } else if("+".equals(token)) {
                    result = num1 + num2;
                } else if("*".equals(token)) {
                    result = num1 * num2;
                } else if("/".equals(token)) {
                    result = num2 / num1;
                }

                stack.push(result);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens =  {"2", "1", "+", "3", "*"};
        int reuslt = new EvaluateReversePolishNotation().evalRPN(tokens);

        System.out.println(reuslt);
    }
}
