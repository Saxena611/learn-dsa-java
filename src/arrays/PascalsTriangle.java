package arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {


    public static void main(String[] args) {
        int n = 5;
        System.out.println(printPascal(n));
        printPascalUsingFormula(n);
    }

    /**
     * ( O(n^2) time and O(n^2) extra space )
     */
    private static List<List<Integer>> printPascal(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row, pre = null;
        for (int i = 0; i < n; i++) {
            row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(pre.get(j - 1) + pre.get(j));
            }
            pre = row;
            res.add(row);
        }
        return res;
    }

    /**
     * ( O(n^2) time and O(1) extra space )
     * <p>
     * Formula deduction :
     * C(line, i)   = line! / ( (line-i)! * i! )
     * C(line, i-1) = line! / ( (line - i + 1)! * (i-1)! )
     * We can derive following expression from above two expressions.
     * C(line, i) = C(line, i-1) * (line - i + 1) / i
     * <p>
     * So C(line, i) can be calculated from C(line, i-1) in O(1) time
     */
    private static void printPascalUsingFormula(int n) {
        for (int line = 1; line <= n; line++) {
            int C = 1;// used to represent C(line, i)
            for (int i = 1; i <= line; i++) {
                // The first value in a line is always 1
                System.out.print(C + " ");
                C = C * (line - i) / i;
            }
            System.out.println();
        }
    }
}