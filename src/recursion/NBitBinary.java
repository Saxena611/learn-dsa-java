package recursion;

import java.util.ArrayList;

public class NBitBinary {

    /*
    * https://practice.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1
    * Input:  N = 3
    * Output: 111 110 101
    * Explanation: 111, 110 and 101 have more
    * than or equal 1's than 0's
    *
    * */

    public static void main(String[] args) {
        NBitBinary nBitBinary = new NBitBinary();
        int n = 3;
        int ones = 0;
        int zeros = 0;
        ArrayList<String> outputList = new ArrayList<>();
        String output = "";
        nBitBinary.solve(ones, zeros, n, outputList, output);

        System.out.println(outputList);
    }

    public void solve(int ones, int zeros, int n, ArrayList<String> outputList, String output) {


        // base condition
        if(n == 0) {
            outputList.add(output);
            return;
        }

        // IP-OP Method
        String op1 = output;
        op1 += "1";
        solve(ones + 1, zeros , n - 1, outputList, op1);

        if (ones > zeros) {
            String op2 = output;
            op2 += "0";
            solve(ones , zeros + 1, n - 1, outputList, op2);
        }
    }
}
