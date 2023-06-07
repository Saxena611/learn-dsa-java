package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

    /**
     * N = 6
     * arr[] = 7 10 4 3 20 15
     * K = 3
     * Output : 7
     * Explanation :
     * 3rd smallest element in the given
     * array is 7.
     *
     * https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=kth-smallest-element
     *
     *
     * */
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        int n = 6;
        System.out.println(kthSmallest(arr, 0, n, k));
    }

    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        //Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0 ; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
