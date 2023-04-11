package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 * */
public class CombinationSumII {

    public static void main(String[] args) {
        int[] arr = {2,5,2,1,2};
        Arrays.sort(arr);
        int target = 5;
        List<List<Integer>> subset = new ArrayList<>();
        combinationSumII(arr, target, 0, new ArrayList<>(), subset);
        System.out.println(subset);
    }

    public static void combinationSumII(int[] arr, int target, int idx, List<Integer> ds, List<List<Integer>> subset) {
        if (target == 0) {
            subset.add(new ArrayList<>(ds));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i-1]) {
                continue;
            }
            if (arr[i] > target) {
                break;
            }
            ds.add(arr[i]);
            combinationSumII(arr, target - arr[i], idx + 1, ds, subset);
            ds.remove(ds.size() - 1);
        }

    }

    static void findCombinations(int ind, int[] arr, int target, List < List < Integer >> ans, List < Integer > ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public static List < List < Integer >> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }


}
