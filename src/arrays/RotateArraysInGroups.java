package arrays;

import java.util.*;

public class RotateArraysInGroups {

    static void reverseInGroups(List<Integer> arr, int n, int k) {
        for(int i = 0 ; i < n ; i += k){
            int left = i;
            int right = Math.min(i+k-1,n-1); // min check if array does not exceed bound

            while(left < right){
                int temp = arr.get(left);
                arr.set(left , arr.get(right));
                arr.set(right,temp);
                left += 1;
                right -= 1;
            }
        }
    }

    public static void main(String[] args) {
        int N = 5, K = 3;
        List<Integer> arr = Arrays.asList(1,2,3,4,5);

        /*
        expected output
        Output: 3 2 1 5 4
        Explanation: First group consists of elements
        1, 2, 3. Second group consists of 4,5.
        */

        reverseInGroups(arr,N,K);
        System.out.println(arr);
    }
}
