package array;

public class Candy {
    public int candy(int[] ratings) {
        int length = ratings.length;
        int num = 1, minCandy=0;

        for(int i = 1; i < length-1; ++i) {
            if(ratings[i-1] < ratings[i]) {
                if(ratings[i] < ratings[i+1]) {
                    ++num;
                }
                if(ratings[i] >= ratings[i+1] || i == length-2){
                    if(i == length-2) {
                        ++num;
                    }
                    minCandy += (num + num*(num-1)/2);
                }
            } else if(ratings[i-1] == ratings[i]) {
                if(i == length-2) {
                    minCandy += 1;
                }
            } else {

            }
        }

        return minCandy;
    }

    public static void main(String[] args) {
        int[] ratings = {0, 1, 2, 2};
        int result = new Candy().candy(ratings);

        System.out.println(result);
    }
}
