package arrays.windowsliding;

import java.util.Arrays;

public class ArrangingArray {

    /**
     * You are given an array of size N. Rearrange the given array in-place such that all
     * the negative numbers occur before positive numbers.
     * (Maintain the  *  order of all -ve and +ve numbers as given in the original array).
     * <p>
     * Input:
     * N = 4
     * Arr[] = {-3, 3, -2, 2}
     * Output:
     * -3 -2 3 2
     */
    public static void main(String[] args) {
        int[] a = {-3, 2, -8, 9, 6, 4, 10, -9, 5};
        arrangeArray(a);
        System.out.println(Arrays.toString(a));
    }

    private static void arrangeArray(int[] a) {
        int i = 0;
        int j = 0;
        while (j < a.length) {
            if (a[j] >= 0) {
                j++;
            } else {
                for (int k = j; k > i; k--) {
                    int temp = a[k];
                    a[k] = a[k - 1];
                    a[k - 1] = temp;
                }
                i++;
                j++;
            }
        }
    }
}
