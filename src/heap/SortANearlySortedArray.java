package heap;

import java.util.Iterator;
import java.util.PriorityQueue;

public class SortANearlySortedArray {


    public static void main(String[] args)
    {
        int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        int n = arr.length;

        // function call
        kSort(arr, n, k);
        printArray(arr, n);
    }

    private static void kSort(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int minCount = Math.min(arr.length, k + 1);
        for (int i = 0; i < minCount ; i++) {
            pq.add(arr[i]); // adding k elements to heap.
        }
        int index = 0;
        for (int j = k + 1; j < n ; j++ ) {
            arr[index++] = pq.peek(); // swapping minimum element to array
            pq.poll();
            pq.add(arr[j]);
        }

        Iterator<Integer> itr = pq.iterator();
        while (itr.hasNext()) {  // adding remaining elements from heap to array.
            arr[index++] = pq.peek();
            pq.poll();
        }
        
    }

    // A utility function to print the array
    private static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
