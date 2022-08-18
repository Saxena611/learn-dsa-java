package recursion;

import java.util.Locale;

public class PermutationWithCaseChange {


    public static void main(String[] args) {
        /*
        * Input: aB
        * Output: ab, Ab, aB, AB
        * */

        String input = "abc";
        String output = "";
        solve(input, output);
    }

    private static void solve(String input, String output){
        if(input.length() == 0){
            System.out.println(output);
            return;
        }

        // Include without upper case
        String output1 = output;
        output1 += input.charAt(0);

        // Include with upper case
        String output2 = output;
        output2 += String.valueOf(input.charAt(0)).toUpperCase(Locale.ROOT);

        input = input.substring(1);

        solve(input, output1);
        solve(input, output2);
    }
}
