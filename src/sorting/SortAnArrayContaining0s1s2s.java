package sorting;

import java.util.Arrays;

public class SortAnArrayContaining0s1s2s {


    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        // There are 2 approaches to the problem
        //  1. Counting algorithm.
        //  2.  Dutch national flag algorithm.
        dutchNationalFlagAlgorithm(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr_reverse = {2, 0, 2, 1, 1, 0};
        dutchNationalFlagAlgorithmReverseOrder(arr_reverse);
        System.out.println(Arrays.toString(arr_reverse));
    }

    public static void dutchNationalFlagAlgorithm(int[] arr) {
        // Three partitions
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    int temp1 = arr[high];
                    arr[high] = arr[mid];
                    arr[mid] = temp1;
                    high--;
                    break;
            }
        }
    }

    public static void dutchNationalFlagAlgorithmReverseOrder(int[] arr) {
        // Three partitions
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    int temp1 = arr[high];
                    arr[high] = arr[mid];
                    arr[mid] = temp1;
                    high--;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
            }
        }
    }
}
