package recursion;

public class PowXN {
    public static void main(String[] args) {
        System.out.println(calculatePow(2, 4));
    }


    public static int calculatePow(int x, int n) {
        // base condition
        if (n == 1) {
            return x;
        }
        
        return calculatePow(x, n - 1)*x;
    }
}
