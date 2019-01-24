package tree.search;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 1);
        int result = 0;

        for (int i = 0; i <= n; i++) {
            result = 0;
            for (int j = 0; i > 1 && j < i; j++) {
                result += (map.get(j) * map.get(i-j-1));
            }
            if(map.get(i) == null) {
                map.put(i, result);
            }
        }

        return result == 0 ? 1: result;
    }

    public int betterNumTree(int n) {
        int[] res = new int[n+1];

        helper(n, res);
        return res[n];
    }

    public int helper(int n, int[] res) {
        if(res[n] != 0) {
            return res[n];
        }

        if(n <= 1) {
            res[n] = 1;

            return res[n];
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += helper(i, res) * helper(n-1-i, res);
        }

        res[n] = sum;

        return res[n];
    }

    public static void main(String[] args) {
        int result = new UniqueBinarySearchTrees().betterNumTree(4);

        System.out.println(result);
    }
}
