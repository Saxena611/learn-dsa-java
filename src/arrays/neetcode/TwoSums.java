package arrays.neetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSums {

    /**
     * https://leetcode.com/problems/two-sum/
     *
     * */

    public static void main(String[] args) {
        int[] arr = {3,2,4};
        int x = 6;

        int[] output = solve(arr, x);
        System.out.println(Arrays.toString(output));
    }

    public static int[] solve(int[] arr, int x) {
        HashMap<Integer, Integer> hashMap =  new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < arr.length ; i++) {

            if (hashMap.containsKey(x - arr[i])) {
                result[0] = hashMap.get(x - arr[i]);
                result[1] = i;
                return result;
            }
            hashMap.put(arr[i], i);
        }
        return result;
    }


}
