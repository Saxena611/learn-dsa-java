package arrays.neetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    /**
     * https://leetcode.com/problems/product-of-array-except-self/
     * Input: nums = [1,2,3,4]
     * Output: [24,12,8,6]
     *
     * */

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] output = productOfArrayExceptSelf(arr);
        System.out.println(Arrays.toString(output));
    }

    public static int[] productOfArrayExceptSelf(int[] arr) {

        // compute array from left
        int[] left = new int[arr.length];
        left[0] = 1;
        for (int i = 1 ; i < arr.length ; i++) {
            left[i] = left[i-1] * arr[i-1];
        }

        // compute array from right
        int[] right = new int[arr.length];
        right[arr.length-1] = 1;
        for (int j = arr.length - 2; j >= 0; j-- ){
            right[j] = right[j + 1] * arr[j+1];
        }

        int[] output = new int[arr.length];
        for (int k = 0 ; k < arr.length ; k++) {
            output[k] = left[k]*right[k];
        }
        return output;
    }
}
