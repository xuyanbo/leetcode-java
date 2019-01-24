package dfs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        helper(n, n, "", res);

        return res;
    }

    public void helper(int left, int right, String sb, List<String> res) {
        if(left < 0 || right < 0 || left > right) return;
        if(left == 0  && right == 0) {
            res.add(sb);
            return;
        }

        helper(left-1, right, sb+"(", res);
        helper(left, right-1, sb+")", res);
    }

    public static void main(String[] args) {
        List<String> res = new GenerateParentheses().generateParenthesis(3);

        for (String val: res) {
            System.out.println(val);
        }
    }
}
