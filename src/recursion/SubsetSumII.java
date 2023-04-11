package recursion;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given an integer array nums that may contain duplicates.
 * Your task is to return all possible subsets. Return only unique subsets and they can be in any order.
 * Input:
 * nums = [1,2,2]
 * Output:
 * [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Explanation:
 * We can have subsets ranging from length 0 to 3. which are listed above.
 * Also, the subset [1,2] appears twice but is printed only once as we require only unique subsets.
 *
 * Expected Time Complexity: O(K2N).
 * Expected Auxiliary Space: O(K2N).
 *
 * */
public class SubsetSumII {


    public static void main(String[] args) {
        int[] arr = {1,2,2};
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        subsetSumII(arr, 0, new ArrayList<>(), output);
        System.out.println(output);
    }

    private static void subsetSumII(int[] arr, int idx, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> output) {
        output.add(new ArrayList<>(ds));
        for (int i = idx; i < arr.length; i++) {
            if (i != idx && arr[i] == arr[i-1]) {
                continue;
            }
            ArrayList<Integer> nds = new ArrayList<>(ds);
            nds.add(arr[i]);
            subsetSumII(arr, i+1, nds, output);
            nds.remove(nds.size() -1);
        }
    }


}
