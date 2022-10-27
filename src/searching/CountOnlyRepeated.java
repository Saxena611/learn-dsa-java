package searching;

public class CountOnlyRepeated {

    /**
     * https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Searching/problem/count-only-repeated2047
     * Count only Repeated
     * Input:
     * N = 5
     * arr[] = {1,2,3,3,4}
     * Output: 3 2
     * Explanation: In the given array, 3 is
     * occuring two times.
     *
     * */


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4};

        onlyRepeatedElements(arr);
    }

    private static void onlyRepeatedElements(int[] arr) {

        int n = arr.length;
        int st = 0;
        int ed = n - 1;

        // Since the array the sorted and consecutive (difference between element is 1).
        // The difference between last (highest) and the first (lowest) gives the count of unique elements.

        int unique = arr[n-1] - arr[0];
        int repeated_count = n - unique;

        // now since you have got the repeated element count as frequency all you need to find is the repeated element.

        while (st < ed ) {

            int mid = (st+ed)/2;

            // since the array is sorted the sum of middle element index and the sum of first element will be greater
            // only if the prior part of the array does not contain repeated element.
            // having such a case will only increase the sum as no increment is being preformed.
            if (arr[mid] >= mid + arr[0]) {
                st = mid + 1;
            } else {
                ed = mid;
            }
        }

        System.out.println("Repeated element " + arr[st] + " Count : " + repeated_count);
    }
}
