package recursion;

public class Fibonacci {


    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(fibIterative(10));
    }

    /**
     * Recursive Approach:
     *
     * Simplicity: The recursive approach directly follows the mathematical definition of the Fibonacci sequence, making it easy to understand and implement.
     * Readability: Recursive code can be more readable and concise, as it closely mirrors the problem's natural recursive structure.
     * Potential for Stack Overflow: For large values of n, the recursive approach can lead to a stack overflow error due to excessive function calls. This limits its practicality for large Fibonacci numbers unless tail recursion optimization is used (not typically available in Java).
     *
     * */
    private static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int num = fib(n-1) + fib(n-2);
        return num;
    }

    /**
     *Efficiency: The iterative approach is generally more efficient than the recursive approach for large values of n. It uses a loop to calculate Fibonacci numbers, avoiding the overhead of recursive function calls.
     * Space Efficiency: The iterative approach uses constant space, while the recursive approach consumes stack space proportional to the depth of the recursion.
     * Avoiding Recalculation: In the recursive approach, you may end up recalculating the same Fibonacci values multiple times, which can be avoided in the iterative approach using an array or a few variables.
     *
     * */
    private static int fibIterative(int n) {
        int start = 0; int next = 1;
        int sum = 0;
        // 0 1 1 2 3 5 ...
        for (int i = 2; i <= n; i++) {
            sum = start + next; // 1 2  3 5
            int temp = next; // 1 1 2
            next = sum; // 1 2 3
            start = temp; // 1 1 2
        }
        return sum;
    }
}
