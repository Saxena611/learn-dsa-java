package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(new Integer[] {2, 1, 5, 4, 3, 0, 0});
        List<Integer> ans = nextGreaterPermutation(A);
        System.out.print("The next permutation is: [");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("]");
    }

    private static List<Integer> nextGreaterPermutation(List<Integer> input) {
        int n = input.size();

        // get the breakpoint.
        int ind = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (input.get(i) < input.get(i+1)) {
                ind = i;
                break;
            }
        }

        // If the whole list is in decreasing order.
        if (ind == -1) {
            Collections.reverse(input);
            return input;
        }

        // swap the index with the closest greatest element to right side of list after the breakpoint.
        // move backwards as the array is in decreasing order till the breakpoint.
        for (int i = n - 1; i > ind; i--) {
            if (input.get(i) > input.get(ind)) {
                int temp = input.get(i);
                input.set(i, input.get(ind));
                input.set(ind, temp);
                break;
            }
        }

        List<Integer> sublist = input.subList(ind+1, n); // reverses by reference the original list.
        Collections.reverse(sublist);
        return input;
    }
}
