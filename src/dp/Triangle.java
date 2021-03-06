package dp;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;

        int[] dp = new int[triangle.size()+1];

        for (int i = triangle.size()-1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3); list2.add(4);
        list.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6); list3.add(5); list3.add(7);
        list.add(list3);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4); list4.add(1); list4.add(8); list4.add(3);
        list.add(list4);

        System.out.println(new Triangle().minimumTotal(list));
    }
}
