package arrays;

public class MaxSubArraySum {

    public static void main(String[] args) {

        int arr[] = {2, 3, -8, 7, -1, 2, 3};

        /*
         *   What is a sub-array ?
         *   Sub-arrays of
         *   {1,2,3} will be
         *   {1} , {2} , {3} ,
         *   {1,2} , {2,3} , {1,2,3}
         *   Max sum of sub-array will be 1,2,3 i.e. 6
         * */


        /*
         * Either extend the sub-array
         * or
         * Start a new one
         * */

        int res = arr[0];
        int maxEnding = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(res, maxEnding);
        }

        System.out.println(res);


    }
}
