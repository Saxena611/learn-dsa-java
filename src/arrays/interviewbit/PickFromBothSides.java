package arrays.interviewbit;

import java.util.Arrays;
import java.util.List;

/**
 *  Given an integer array A of size N.
 *
 * You have to pick exactly B elements from either left or right end of the array A to get the maximum sum.
 *
 * Find and return this maximum possible sum.
 *
 * NOTE: Suppose B = 4 and array A contains 10 elements then
 *
 * You can pick the first four elements or can pick the last four elements or can pick 1 from the front and 3 from the back etc. you need to return the maximum possible sum of elements you can pick.
 *
 *
 * */
public class PickFromBothSides {

    public static void main(String[] args) {

        List<Integer> input = Arrays.asList(5, -2, 3 , 1, 2);
        int b = 3;
        int output = solve(input, 3);
        System.out.println(output);
    }

    private static int solve(List<Integer> input, int b) {
        int max_sum = 0;

        for (int i = 0 ; i < b; i++) {
            max_sum += input.get(i);
        }

        if (input.size() == b) {
            return max_sum;
        }

        int localSum = max_sum;
        int startPointer = b - 1;
        int endPointer = input.size() - 1;
        for (int j = startPointer; j >= 0; j--) {
            localSum -= input.get(j);
            localSum += input.get(endPointer);
            max_sum = Math.max(localSum, max_sum);
            endPointer--;
        }

        return max_sum;
    }
}
