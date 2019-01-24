package divide_conquer;

public class Pow {
    public double myPow(double x, int n) {
        if(n > 0) return power(x, n);
        return 1 / power(x, -n);
    }

    public double power(double x, int n) {
        if(n == 0) return 1;

        double v = power(x, n/2);
        if(n % 2 == 0) return v * v;
        else return v * v * x;
    }

    public static void main(String[] args) {
        System.out.println(new Pow().myPow(0.00001, 2147483647));
    }
}
