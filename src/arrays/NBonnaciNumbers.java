package arrays;

import java.util.Arrays;

public class NBonnaciNumbers {


    public static void main(String[] args) {
        int N = 5, M = 15;
        bonacciseries(N, M);
    }

    private static void bonacciseries(int n, int m) {
        int[] arr = new int[m];

        for(int i = 0 ; i < m ; i++){
            arr[i] = 0;
        }

        arr[n-1] = 1;
        arr[n] = 1;

        for(int j =  n + 1 ; j < m ; j++){
            arr[j] = 2 * arr[j-1] - arr[j - n - 1];
        }

        System.out.println(Arrays.toString(arr));
    }
}
