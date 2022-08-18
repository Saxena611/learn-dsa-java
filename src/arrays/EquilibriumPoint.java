package arrays;

public class EquilibriumPoint {

    /*
    * Based on Prefix sum.
    *
    * Equlibrium point is the position in the array
    * where right sum of array is equal to the left sum of array.
    *
    * For an array{3 , 4  , 8 , -9, 20 , 6}
    * index 4 will be considered as equilibrium point as sum of
    * left {3,4,8,-9} is 6 and sum of right i.e {6} is equal.
    * */

    public static void main(String[] args) {
        int arr[] = {3, 4, 8, -9, 20, 6}, n = 6;

        System.out.println(checkEquilibrium(arr, n));
    }

    private static boolean checkEquilibrium(int[] arr, int n) {
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += arr[i];
        }
        // search for equlibrium point
        int l_sum = 0;
        for(int i = 0 ; i < n ; i++){
            if(l_sum == sum - arr[i]){
                return true;
            }
            l_sum += arr[i];
            sum -= arr[i];
        }
        return false;
    }

}
