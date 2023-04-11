package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all valid combinations of K numbers that sum upto to N such that the following conditions are true:
 *
 * Only number 1 through 9 are used.
 * Each number is used atmost once.
 * Return the list of all possible valid combinations.
 *
 * Note: The list must not contain the same combination twice, and the combinations returned in any order.
 *
 * Input:
 * K = 3
 * N = 7
 * Output: { {1, 2, 4} }
 * Explanation:
 * 1+ 2+ 4 = 7
 * There are no other valid combinations.
 *
 *
 * */
public class CombinationSumIII {


    public static void main(String[] args) {
        int n = 9;
        int k = 3;

        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i-1] = i;
        }
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        // combinationSumIII(arr, 0, 0, k, n,new ArrayList<>(), output);
        combinationSumIII(1, n, k, new ArrayList<>(), output);
        System.out.println(output);
    }

    public static void combinationSumIII(int[] arr, int idx, int sum, int k, int n, List<Integer> ds, List<List<Integer>> output) {

        // base condition
        if (ds.size() == k) {
            if (sum == n) {
                output.add(new ArrayList<>(ds));
            }
            return;
        }

        if (sum > n) {
            return;
        }


        for (int i = idx; i < n - k; i++) {
            List<Integer> nds = new ArrayList<>(ds);
            nds.add(arr[i]);
            combinationSumIII(arr, i + 1, sum + arr[i], k, n, nds, output);
            nds.remove(nds.size() - 1);
        }

    }

    public static void combinationSumIII(int idx, int n, int k, ArrayList<Integer> ds,  ArrayList<ArrayList<Integer>> output) {

        // base condition
        if (ds.size() == k && n == 0) {
            output.add(new ArrayList<>(ds));
            return;
        }

        if (n < 0) {
            return;
        }

        if (idx > 9) {
            return;
        }

        ArrayList<Integer> nds = new ArrayList<>(ds);
        nds.add(idx);
        combinationSumIII(idx + 1, n - idx, k, nds, output);
        nds.remove(nds.size() - 1);
        combinationSumIII(idx + 1, n, k, nds,  output);

    }


}
