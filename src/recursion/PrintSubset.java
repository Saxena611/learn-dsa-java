package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubset {


    public static void main(String[] args) {
        PrintSubset ps = new PrintSubset();
        String input = "gfg";
        String output = "";

        List<String> outputList = new ArrayList<>();
        ps.solve(input, output,  outputList);
        System.out.println(outputList);
        // ps.printAllSubset(input, output);

    }

    private void printAllSubset(String input, String output) {

        if (input.length() == 0) {
            System.out.print(output + " ");
            return;
        }

        // decisive operations
        String output1 = output;
        String output2 = output;

        output2 += String.valueOf(input.charAt(0));

        input = input.substring(1);

        // recursive calls
        printAllSubset(input, output1); // exclusive operation
        printAllSubset(input, output2); // inclusive operation

        return;
    }

    public void solve(String input, String output, List<String> outputList) {
        if (input.isEmpty()) {
            outputList.add(output);
            return;
        }

        String out1 = output;
        String out2 = output;

        out1 += input.charAt(0);
        StringBuilder sb = new StringBuilder(input);
        sb.deleteCharAt(0);
        input = sb.toString();
        solve(input, out1,  outputList);
        solve(input, out2,  outputList);

    }
}
