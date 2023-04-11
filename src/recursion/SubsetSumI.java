package recursion;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  Given a list arr of N integers, print sums of all subsets in it.
 *  Input:
 * N = 2
 * arr[] = {2, 3}
 * Output:
 * 0 2 3 5
 * Explanation:
 * When no elements is taken then Sum = 0.
 * When only 2 is taken then Sum = 2.
 * When only 3 is taken then Sum = 3.
 * When element 2 and 3 are taken then
 * Sum = 2+3 = 5.
 *
 * Printed sum should be in increasing order.
*
* */
public class SubsetSumI {


    public static void main(String[] args) {
        int[] arr = {5,2,1};
        List<Integer> output = new ArrayList<>();
        subsetSumI(arr, 0, 0,output);
        Collections.sort(output);
        System.out.println(output);
    }

    public static void subsetSumI(int[] arr, int idx, int sum, List<Integer> output) {

        // base condition
        if (idx == arr.length) {
            output.add(sum);
            return;
        }

        subsetSumI(arr, idx + 1, sum + arr[idx], output);
        subsetSumI(arr, idx + 1, sum, output);
    }
}
