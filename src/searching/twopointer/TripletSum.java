package searching.twopointer;

import java.util.Arrays;
import java.util.Collections;

public class TripletSum {

    public static void main(String[] args) {
        int arr[] = { 1, 4, 45, 6, 10, 8 };
        int sum = 22;
        
        boolean output = find3Sum(arr, sum);
        System.out.println(output);
    }

    private static boolean find3Sum(int[] arr, int sum) {
        Arrays.sort(arr);
        for (int i = 0 ; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] == sum) {
                    return true;
                } else if (arr[i] + arr[j] + arr[k] < sum) {
                    j++;
                } else {
                    k--;
                }

            }
        }
        return false;
    }
}
