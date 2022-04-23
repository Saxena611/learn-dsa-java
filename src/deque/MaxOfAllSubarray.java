package deque;

import java.util.Deque;
import java.util.LinkedList;

public class MaxOfAllSubarray {

    /*
    * Given a array find the ma n all subarray of size k
    * arr[] = {10.3.5,12,15,7} , k= 3 , o/p =
    * n - k + 1 number of elements as output
     */


    public static void main(String[] args) {

        int arr[] =  {10,8,5,12,15,7};
        int k = 3;
        // naive solution - O(n square)
        for (int i = 0 ; i < arr.length ; i++){
            int max = arr[i];
            for(int j = i + 1; j < i + k ; j++){
                max = Math.max(arr[j],max);
            }
            System.out.println(max);
        }

        // Optimized solution using Deque
        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0 ; i < k ; i++){

        }
    }
}
