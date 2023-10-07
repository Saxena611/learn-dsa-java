package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    /**
     * Input:
     * N = 5, k = 2
     * arr[] = {12,5,787,1,23}
     * Output: 787 23
     * Explanation: First largest element in
     * the array is 787 and the second largest
     * is 23.
     * <p>
     * https://practice.geeksforgeeks.org/problems/k-largest-elements3736/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=k-largest-elements
     */
    public static void main(String[] args) {
        int[] arr = {12, 5, 787, 1, 23};
        int n = 5;
        int k = 2;
        System.out.println(kLargest(arr, n, k));
    }

    public static ArrayList<Integer> kLargest(int arr[], int n, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);

            if (pq.size() > k) {
                pq.poll(); // reduces complexity to O nlogk
            }

        }
        ArrayList<Integer> alist = new ArrayList<>();
        while (!pq.isEmpty()) {
            int element = pq.poll();
            alist.add(element);
        }
        Collections.reverse(alist);
        return alist;
    }
}
