package arrays;

public class MergeTwoSortedArraysWithoutUsingExtraSpace {

    /**
     * https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/
     * <p>
     * Example 1:
     * <p>
     * Input:
     * n = 4, arr1[] = [1 4 8 10]
     * m = 5, arr2[] = [2 3 9]
     * <p>
     * Output:
     * arr1[] = [1 2 3 4]
     * arr2[] = [8 9 10]
     * <p>
     * Explanation:
     * After merging the two non-decreasing arrays, we get, 1,2,3,4,8,9,10.
     * <p>
     * Example2:
     * <p>
     * Input:
     * n = 4, arr1[] = [1 3 5 7]
     * m = 5, arr2[] = [0 2 6 8 9]
     * <p>
     * Output:
     * arr1[] = [0 1 2 3]
     * arr2[] = [5 6 7 8 9]
     * <p>
     * Explanation:
     * After merging the two non-decreasing arrays, we get, 0 1 2 3 5 6 7 8 9.
     */
    public static void main(String[] args) {
        int arr1[] = {1, 4, 7, 8, 10};
        int arr2[] = {2, 3, 9};
        System.out.println("Before merge:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        merge(arr1, arr2, arr1.length, arr2.length);
        System.out.println("After merge:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }


    /**
     * Another approach is using GAP algorithm.(Hard to code).
     * Will review it afterwards.
     */
    private static void merge(int[] arr1, int[] arr2, int n, int m) {
        int i, k;
        for (i = 0; i < n; i++) {

            if (arr1[i] > arr2[0]) {
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
            }

            // Insertion sort technique - optimized
            // Bubble sort can also be used.
            int first = arr2[0]; // cache the new element
            for (k = 1; k < m && arr2[k] < first; k++) {
                // fit the element at the right place
                arr2[k - 1] = arr2[k];
            }
            // fit the element just before k.
            arr2[k - 1] = first;
        }
    }
}
