package sorting;

import java.util.Arrays;

public class SelectionSort {


    public static void main(String[] args) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        // for each iteration we find the minimum
        // element from the entire array and swap it
        // with the current value
        for (int i = 0; i < arr.length; i++) {
            int idx = findMinimum(arr, i);
            // swap
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }

    private static int findMinimum(int[] arr, int i) {
        int minIdx = i;
        for (int j = i+1; j < arr.length; j++) {
            if (arr[minIdx] > arr[j]) {
                minIdx = j;
            }
        }
        return minIdx;
    }
}
