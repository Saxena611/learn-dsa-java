package recursion;

public class PermutationWithSpaces {


    public static void main(String[] args) {
        /*
        * Input : ABC
        *
        * Output : A_BC, A_B_C, AB_C, ABC
        *
        * */


        String input = "ABC";
        String output = "";

        output = String.valueOf(input.charAt(0));
        input = input.substring(1);
        solve(input, output);
    }


    private static void solve(String input, String output){
        if (input.length() == 0){
            System.out.println(output);
            return;
        }

        // include without space
        String output1 = output;
        output1 += String.valueOf(input.charAt(0));

        // include with space
        String output2 = output;
        output2 += "_" + String.valueOf(input.charAt(0));

        input = input.substring(1);

        solve(input, output1);
        solve(input, output2);
    }
}
