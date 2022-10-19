package recursion;

import java.util.*;
import java.util.stream.Collectors;

public class UniqueSubsets {


    /**
     * https://practice.geeksforgeeks.org/problems/subsets-1587115621/1
     * Given an array arr[] of integers of size N that might contain duplicates, the task is to find all possible unique subsets.
     * Input: N = 3, arr[] = {2,1,2}
     * Output:(),(1),(1 2),(1 2 2),(2),(2 2)
     * Explanation:
     * All possible subsets = (),(2),(1),(1,2),(2),(2,2),(2,1),(2,1,2)
     * After Sorting each subset = (),(2),(1),(1,2),(2),(2,2),(1,2),(1,2,2)
     * Unique Susbsets in Lexicographical order = (),(1),(1,2),(1,2,2),(2),(2,2)
     */

    ArrayList<ArrayList<Integer>> outputList;

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(2,1,2));
        int idx = 0;
        List<List<Integer>> subset = new ArrayList<>();
        // solve(subset, input, new ArrayList<>(), idx);
        solve(subset, input, new ArrayList<Integer>());
        System.out.println(subset);

    }

    private static void solve(List<List<Integer>> subset, List<Integer> input, ArrayList<Integer> output) {
        if (input.size() == 0) {
            subset.add(output);
            return;
        }
        int temp = input.get(0);
        input.remove(0);

        // exclude
        solve(subset, new ArrayList<>(input), new ArrayList<>(output));

        // include
        output.add(temp);
        solve(subset, new ArrayList<>(input), new ArrayList<>(output));


    }

    private static void solve(List<List<Integer>> subset, List<Integer> input, List<Integer> output, int idx) {
        if (idx == input.size()) {
            subset.add(output);
            return;
        }

        // exclude
        solve(subset, input, new ArrayList<>(output), idx + 1);

        // include
        output.add(input.get(idx));
        solve(subset, input, new ArrayList<>(output), idx + 1);
    }

}
