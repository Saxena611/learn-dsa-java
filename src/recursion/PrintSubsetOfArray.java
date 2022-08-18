package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintSubsetOfArray {

    List<List<Integer>> external;

    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3));
        PrintSubsetOfArray printSubsetOfArray = new PrintSubsetOfArray();
        printSubsetOfArray.external = new ArrayList<>();
        printSubsetOfArray.printSubsetOfArray(arr,new ArrayList<>());
        System.out.println(printSubsetOfArray.external);
        String s = "animesh";
    }

    private void printSubsetOfArray(List<Integer> input , List<Integer> output) {
        if(input.size() == 0){
            external.add(output);
            return;
        }

        List<Integer> op1 = new ArrayList<>(output);
        List<Integer> op2 = new ArrayList<>(output);

        op2.add(input.get(0));
        input.remove(0);

        printSubsetOfArray(input,op1);
        printSubsetOfArray(input,op2);

        return;

    }

}
