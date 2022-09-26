package arrays.windowsliding;

import java.util.ArrayList;

public class FirstNegativeNumber {

    /*
    * Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.
    * Input :
      N = 5
      A[] = {-8, 2, 3, -6, 10}
      K = 2
      Output :
      -8 0 -6 -6
     * */


    public static void main(String[] args) {
        int[] arr = {-8, 2, 3, -6, 10};
        int n = arr.length;
        int k = 2;

        ArrayList<Integer> outputList = getFirstNegativeNumber(arr, k);
        System.out.println(outputList);
    }

    private static ArrayList<Integer> getFirstNegativeNumber(int[] arr, int k) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> outputList = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();


        while (j  < arr.length) {
            if (arr[j] < 0) {
                tempList.add(arr[j]);
            }

            if ((j - i + 1) < k) {
                j += 1;
            } else  if ((j - i + 1 ) == k) {
                if (tempList.isEmpty()) {
                    outputList.add(0);
                } else {
                    outputList.add(tempList.get(0));
                    if (arr[i] == tempList.get(0)) {
                        tempList.remove(0);
                    }
                }
                i++;
                j++;
            }
        }
        return outputList;
    }
}
