package divide_conquer;

public class Sqrt {
    public int mySqrt(int x) {
        if(x == 1) return 1;

        for(int i = 1; i <= x; ++i) {
            if(Math.pow(i,2) == x) {
                return i;
            } else if(Math.pow(i, 2) > x) {
                return i-1;
            }
        }

        return 0;
    }

    public int betterMySqrt(int x) {
        if(x < 1) {
            return 0;
        } else if(x < 4) {
            return 1;
        }

        int left = 0, right = x;

        while(left <= right) {
            int m = left + (right - left) / 2;
            if(m == x/m) {
                return m;
            } else if(m < x/m) {
                left = m+1;
            } else if(m > x/m) {
                right = m-1;
            }
        }

        return left-1;
    }

    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(90));
    }
}
