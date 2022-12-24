package searching.twopointer;

public class TwoPointerConcept {


    public static void main(String[] args) {
        /**
         * Given a sorted array A (sorted in ascending order),
         * having N integers, find if there exists any pair of elements (A[i], A[j]) such that their
         * sum is equal to X.
         *
         * Input:
         * A[] = {10, 20, 35, 50, 75, 80}
         * X = 70
         * Output: True
         * */

        int[] arr = {10, 20, 35, 50, 75, 80};
        int x = 70;
        boolean output = pairSumExist(arr, x);
        System.out.println(output);
    }


    /**
     * We take two pointers, one representing the first element and other representing the last element of the array,
     * and then we add the values kept at both the pointers.
     * If their sum is smaller than X then we shift the left pointer to right or if their sum is greater than X
     * then we shift the right pointer to left,
     * in order to get closer to the sum. We keep moving the pointers until we get the sum as X.
     *
     * */
    protected static boolean pairSumExist(int[] arr, int x) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] == x) {
                return true;
            } else if (arr[i] + arr[j] < x) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
