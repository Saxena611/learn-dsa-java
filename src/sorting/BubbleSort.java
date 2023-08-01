package sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        // bubble sort , simply compares its next adjacent element.
        // In case the element is greater the adjacent element.
        // It simply gets swapped.
        // Also, as the outer loop progresses the later values
        // which are higher in values keep on getting eliminated to
        // become a part of the comparison flow.
        for (int i = 0 ; i < arr.length ; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
