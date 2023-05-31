package stack;


import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array arr[ ] of size N having elements,
 * the task is to find the next greater element for each element of the array in order of their appearance in the array.
 * Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
 * If there does not exist next greater of current element,
 * then next greater element for current element is -1. For example, next greater of the last element is always -1.
 * <p>
 * Input:
 * N = 4, arr[] = [1 3 2 4]
 * Output:
 * 3 4 4 -1
 * Explanation:
 * In the array, the next larger element
 * to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ?
 * since it doesn't exist, it is -1.
 */
public class NextGreaterElement {


    public static void main(String[] args) {
        long[] arr = {7, 8, 1, 4};
        long[] output = getNextGreaterElements(arr, arr.length);
        System.out.println(Arrays.toString(output));
    }

    private static long[] getNextGreaterElements(long[] arr, int n) {
        Stack<Long> stk = new Stack<>();
        long[] output = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            while (stk.isEmpty() == false && stk.peek() <= arr[i]) {
                stk.pop();
            }
            if (stk.isEmpty() == false) {
                output[i] = stk.peek();
            } else {
                output[i] = -1;
            }
            stk.push(arr[i]);
        }
        return output;
    }


    private static long[] secondApproach(long[] arr, int n) {
        Stack<Long> stk = new Stack<>();
        long[] output = new long[n];

        for (int i = n - 1; i >= 0; i--) {
            if (stk.isEmpty()) {
                output[i] = -1;
            }

            if (!stk.isEmpty() && stk.peek() >= arr[i]) {
                output[i] = stk.peek();
            }

            if (!stk.isEmpty() && stk.peek() <= arr[i]) {
                while (!stk.isEmpty() && stk.peek() <= arr[i]) {
                    stk.pop();
                }
                if (stk.isEmpty()) {
                    output[i] = -1;
                } else {
                    output[i] = stk.peek();
                }
            }
        }
        return output;
    }

}
