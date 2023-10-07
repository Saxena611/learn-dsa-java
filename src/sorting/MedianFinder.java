package sorting;

import java.util.*;

/**
 * Given a stream of data calculate the median for each element streams.
 * The array can be long in terms of the dataset.
 * Input arr[] = {5, 2, 8, 10, 1};
 *
 * Output:
 * Median: 5.0 , for input[] = 5
 * Median: 3.5 , for input[] = 5, 2
 * Median: 5.0 , for input[] = 5, 2, 8
 * Median: 6.5
 * Median: 5.0
 *
 * Median for the input stream is the middle most element of the array in case array is even length.
 * In case of odd length array it is the average of 2 middle elements.
 * */
public class MedianFinder {

    public static void main(String[] args) {
        int[] input = {5, 2, 8, 10, 1};
        findMedian(input);
    }

    public static void findMedian(int[] input) {
        // stream through the long stream of data.
        List<Integer> tempArr = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            tempArr.add(input[i]);
            // bubbleSort(tempArr);
            Collections.sort(tempArr);
            int median = calculateMedian(tempArr);
            System.out.println("Median: " + median);
        }
    }

    public static int calculateMedian(List<Integer> tempArr) {
        int output = 0;
        int size = tempArr.size();
        if (tempArr.size()%2 == 0) {
            output = (tempArr.get(size/2) + tempArr.get(size/2 - 1))/2;
        } else {
            output = tempArr.get(size/2);
        }
        return output;
    }

    public static void bubbleSort(List<Integer> tempArr) {
        for (int i = 0; i < tempArr.size(); i++) {
            for (int j = i ; j < tempArr.size() - i - 1; j++) {
                if (tempArr.get(j) > tempArr.get(j+1)) {
                    int temp = tempArr.get(j);
                    tempArr.add(j, tempArr.get(j+1));
                    tempArr.add(j+1, temp);
                }
            }
        }
    }
}
