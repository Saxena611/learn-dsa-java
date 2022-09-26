package arrays.windowsliding;

import java.util.Map;

public class LargestSubArrayOfSumK {


    public static void main(String[] args) {

        int[] arr = {4,1,1,3,2,3,5,1,1,1,1,1};
        int k = 5;

//        int arr[] = { 10, 5, 2, 7, 1, 9 };
//        int k = 15;

        int output = largestSubArrayOfSizeK(arr, k);
        System.out.println(output);
    }


    public static int largestSubArrayOfSizeK(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int curr_sum = 0;
        int max_len = Integer.MIN_VALUE;
        while (j < arr.length) {
            curr_sum += arr[j];

            if (curr_sum < k) {
                j++;
            }

            if (curr_sum == k) {
                max_len = Math.max(max_len, (j-i+1));
                j++;
            }

            if (curr_sum > k) {
                while (curr_sum > k) {
                    curr_sum -= arr[i];
                    i++;
                }
                if (curr_sum == k) {
                    max_len = Math.max(max_len, curr_sum);
                }
                j++;
            }
        }
        return max_len;
    }
}
