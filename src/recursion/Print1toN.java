package recursion;

public class Print1toN {



    public static void main(String[] args) {
        print1toN(100);
        System.out.println("\n");
        printNto1(100);
    }

    private static void printNto1(int i) {
        if(i == 0){
            return;
        }

        System.out.print(i + ",");

        printNto1(i-1);
    }

    private static void print1toN(int i) {
        // Base condition
        if(i == 0){
            return;
        }

        // Hypothesis
        print1toN(i-1);

        // Induction
        System.out.print(i + ",");

    }
}
