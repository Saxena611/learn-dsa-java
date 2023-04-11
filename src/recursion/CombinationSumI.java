package recursion;


/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 *  of at least one of the chosen numbers is different.
 *
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 *
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 *
 */

import java.util.ArrayList;
import java.util.List;
public class CombinationSumI {

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> subset = new ArrayList<>();

        combinationSum(arr, 0, target, new ArrayList<>(), subset);

        System.out.println(subset);
    }

    static void combinationSum(int[] arr, int index, int target, List<Integer> ds, List<List<Integer>> subset) {
        // base condition
        if (index == arr.length) {
            if (target == 0) {
                subset.add(ds);
                return;
            }
            return;
        }

        List<Integer> nds = new ArrayList<>(ds);
        if (arr[index] <= target) {
            nds.add(arr[index]);
            combinationSum(arr, index, target - arr[index], nds, subset);
            nds.remove(nds.size() - 1);
        }
        combinationSum(arr, index + 1, target, nds, subset);
    }

    
}
