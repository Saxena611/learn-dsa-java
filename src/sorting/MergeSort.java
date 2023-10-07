package sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int n = 7;
        int arr[] = { 9, 4, 7, 6, 3, 1, 5 };
        System.out.println("Before sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        MergeSort mergeSort = new MergeSort();
        mergeSort(arr, 0, n - 1);
        System.out.println("After sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void mergeSort(int[] arr, int left, int right) {
        // base condition
        if (left >= right) {
            return;
        }

        int mid = (right + left)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);

        merge(arr, left, mid, right);
    }

    private static  void merge(int[] arr,  int left, int mid, int right) {
        // we are provided with 2 array index we need to merge them
        int low = left;
        int high = mid + 1;
        List<Integer> temp = new ArrayList<>();
        while (low <= mid && high <= right) {
            if (arr[low] <= arr[high]) {
                temp.add(arr[low]);
                low++;
            } else {
                temp.add(arr[high]);
                high++;
            }
        }

        while (low <= mid) {
            temp.add(arr[low]);
            low++;
        }

        while (high <= right) {
            temp.add(arr[high]);
            high++;
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp.get(i - left); // smartly adding elements from temp list to actual array index.
        }
    }

    private void mergeAnotherApproach(int[] arr, int left, int mid, int right) {
        int i, j, k;

        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid ;

        int[] leftArr = new int[sizeLeft];
        int[] rightArr = new int[sizeRight];

        for (i = 0; i < sizeLeft; i ++) {
            leftArr[i] = arr[left + 1];
        }

        for (j = 0; j < sizeRight; j++) {
            rightArr[i] = arr[j];
        }

        i = 0;
        j = 0;
        k = left;

        while (i < sizeLeft && j < sizeRight) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copying the remaining elements of leftArr[], if there are any
        while (i < sizeLeft) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy the remaining elements of rightArr[], if there are any
        while (j < sizeRight) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
