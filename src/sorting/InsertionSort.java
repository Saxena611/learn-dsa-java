package sorting;

import java.util.Arrays;
public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void insertionSort(int[] arr) {
        for (int i = 1 ; i < arr.length; i++) {
            int element = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > element) {
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = element;
        }
    }
}
