package recursion;

public class PrintSubset {


    public static void main(String[] args) {
        PrintSubset ps = new PrintSubset();

        String input = "aab";
        String output = "";
        ps.printAllSubset(input, output);

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
}
