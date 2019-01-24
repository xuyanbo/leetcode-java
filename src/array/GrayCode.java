package array;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        if(n < 0) return list;

        list.add(0);

        for(int i = 0; i < n; ++i) {
            int length = list.size();
            for(int j = length-1; j >= 0; --j) {
                list.add((int)Math.pow(2, i) + list.get(j));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new GrayCode().grayCode(3);
        for(int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }
    }
}
