package recursion;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class LetterCasePermutation {

    public static void main(String[] args) {

        String input = "a1B2";
        String output = "";

        Set<String> outputSet = new HashSet<>();
        solve(input, output, outputSet);
        System.out.println(outputSet);
    }

    private static void solve(String input, String output, Set<String> outputSet){
        if(input.length() == 0){
            outputSet.add(output);
            return;
        }


        if(isNumeric(String.valueOf(input.charAt(0)))){
            String output1 = output;
            output1 += input.charAt(0);
            input = input.substring(1);
            solve(input, output1, outputSet);
        } else {
            // exclusive operation without upper case
            String output1 = output;
            // inclusive operation with upper case
            String output2 = output;
            output1 += String.valueOf(input.charAt(0)).toLowerCase(Locale.ROOT);
            output2 += String.valueOf(input.charAt(0)).toUpperCase(Locale.ROOT);
            input = input.substring(1);

            solve(input, output1, outputSet);
            solve(input, output2, outputSet);

        }


    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
