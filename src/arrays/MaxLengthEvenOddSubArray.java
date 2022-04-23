package arrays;

public class MaxLengthEvenOddSubArray {

    /*
    * Based out of Kaden's Algorithm
    * 1. Either start a new sub-array
    *              OR
    * 2. Start a new one
    * */

    static int maxEvenOdd(int[] arr,int n){

        int res = 1;
        int curr = 1;

        for(int i = 1; i < n ; i++){

            // check for alternating
            if((arr[i]%2 == 0 && arr[i-1]%2 != 0) ||
                    (arr[i]%2 != 0 && arr[i-1]%2 == 0)){
                curr++;
                res = Math.max(res,curr);
            }else{
                curr = 1;
            }

        }
        return res;

    }


    public static void main(String[] args) {
        int arr[] = {5, 10, 20, 6, 3, 8}, n = 6;

        System.out.println(maxEvenOdd(arr, n));
    }
}
