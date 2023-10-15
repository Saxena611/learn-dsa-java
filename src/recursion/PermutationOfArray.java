package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationOfArray {


    public static void main(String[] args) {
        int[] input = {3,2,1};
        List<List<Integer>> outputList = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] freq = new boolean[input.length];
        Arrays.fill(freq, false);
        permutation(input, outputList, current, freq);
        System.out.println(outputList);
    }

    private static void permutation(int[] input, List<List<Integer>> outputList, List<Integer> current, boolean[] freq) {
        if (current.size() == input.length) {
            outputList.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                current.add(input[i]);
                permutation(input, outputList, current, freq);
                // backtracking to remove previous marking and computations.
                current.remove(current.size() - 1);
                freq[i] = false;
            }
        }
    }
}
