package array;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        if(n <= 0 || k <= 0 || n > 9) return "";

        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1));
        int[] allCount = {1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

        int i = n-2, numcount, length, index;
        int pre_index = list.size() - n;
        for(; i > -2; --i) {
            length = list.size();

            if(i >=0 && k <= allCount[i+1] && k >= allCount[i]) {
                numcount = k / allCount[i];
                if(k % allCount[i] != 0) {
                    index = numcount;
                } else {
                    index = numcount-1;
                }
                sb.append(list.get(length-1-index));
                list.remove(length-1-index);
                k = k - numcount * allCount[i];

            } else {
                if(k == 0) {
                    sb.append(list.get(pre_index));
                    list.remove(pre_index);
                } else {
                    sb.append(list.get(length-1));
                    list.remove(length-1);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String result = new PermutationSequence().getPermutation(3, 6);

        System.out.println(result);
    }
}
