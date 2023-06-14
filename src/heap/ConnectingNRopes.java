package heap;

import java.util.PriorityQueue;

public class ConnectingNRopes {
    /**
     *
     * Input: arr[] = {4,3,2,6} , N = 4
     * Output: 29
     * Explanation:
     *
     * First, connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6, and 5.
     * Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
     * Finally connect the two ropes and all ropes have connected.
     *
     *
     * */
    static int minCost(int arr[], int n) {
        // Create a priority queue
        PriorityQueue<Integer> pq
                = new PriorityQueue<>();

        // Adding items to the pQueue
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        // Initialize result
        int res = 0;

        // While size of priority queue
        // is more than 1
        while (pq.size() > 1) {
            // Extract shortest two ropes from pq
            int first = pq.poll();
            int second = pq.poll();

            // Connect the ropes: update result
            // and insert the new rope to pq
            res += first + second;
            pq.add(first + second);
        }

        return res;
    }

    // Driver program to test above function
    public static void main(String args[]) {
        int len[] = {4, 3, 2, 6};
        int size = len.length;
        System.out.println("Total cost for connecting"
                + " ropes is "
                + minCost(len, size));
    }
}
