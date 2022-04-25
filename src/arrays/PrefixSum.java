package arrays;

public class PrefixSum {

    /*
    * Given a fixed array and multiple queries of following types
    * on the array , how to effectively perform these queries.
    *
    * Input = {2,8,3,9,6,5,4}
    * Queries = getSum(0,2) , getSum(1,4)
    *
    * Challenge here is to solve the problem in O(n) time complexity
    * where each operation take exactly O(1) time.
    * */

    public static void main(String[] args) {
        int arr[] = {2, 8, 3, 9, 6, 5, 4}, n = 7;

        int prefix_sum[] = preSum(arr, n);

        System.out.println(getSum(prefix_sum, 1, 3));

        System.out.println(getSum(prefix_sum, 0, 2));
    }

    private static int getSum(int[] prefix_sum, int l, int r) {
        if(l != 0){
            /*
            * Substracting curr_sum i.e. at point L by the previous computed sum
            * till the point R - 1 . Gives the total sum between L to R .
            * */
            return prefix_sum[r] - prefix_sum[l - 1];
        }else {
            return prefix_sum[r];
        }
    }

    private static int[] preSum(int[] arr, int n) {
        /*
        * Pre-process array consist sum of previous element indexes.
        * */
        int[] pre_process = new int[n];
        pre_process[0] = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            pre_process[i] = pre_process[i-1] + arr[i];
        }
        return pre_process;
    }
}
