package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumProblem {

    /**
     * Four sum problem
     * Based on two pointer approach.
     * https://takeuforward.org/data-structure/4-sum-find-quads-that-add-up-to-a-target-value/
     * 
     *
     * */
    public static void main(String[] args) {

        int arr[] = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> ls = fourSum(arr, target);
        for (int i = 0; i < ls.size(); i++) {
            for (int j = 0; j < ls.get(i).size(); j++) {
                System.out.print(ls.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return res;
        }
        int n = arr.length;
        Arrays.sort(arr);
        // a + b + c + d = target
        // c + d = target - (a + b)
        // You have a + b
        // You know new target to achieve i.e. target-(a+b)
        // You need to find value of c and d which equates to target-(a+b) .
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int nTarget = target - (arr[i] + arr[j]);
                int low = j + 1;
                int hi = n - 1;
                while (low < hi) {
                    int twoSum = arr[low] + arr[hi];
                    if (twoSum > nTarget) {
                        hi--;
                    } else if (twoSum < nTarget) {
                        low--;
                    } else {
                        List<Integer> list = Arrays.asList(arr[i], arr[j], arr[low], arr[hi]);
                        res.add(list);

                        while (low < hi && arr[low] == arr[low + 1]) low++;
                        while (low < hi && arr[hi] == arr[hi - 1]) hi--;

                    }
                }
                while (j + 1 < n && arr[j] == arr[j + 1]) j++;
            }
            // Since the array is sorted.
            // duplicate elements can be removed from being considered as element that contribute to generate result.
            while (i + 1 < n && arr[i] == arr[i + 1]) i++;
        }

        return res;


    }
}
