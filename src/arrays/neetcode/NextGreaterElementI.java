package arrays.neetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI  {

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] output = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(output));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> hmap = new HashMap<>();
        // distinct array , elements are unique.
        // element -> index
        for (int i = 0; i < nums2.length; i++) {
            hmap.put(nums2[i], i);
        }

        Stack<Integer> stk = new Stack<>();
        int[] gtElement = new int[nums2.length];
        for (int j = nums2.length - 1 ; j >= 0; j--) {
            if (stk.isEmpty()) {
                stk.push(nums2[j]);
                gtElement[j] = -1;
            } else if (!stk.isEmpty() &&
                    stk.peek() > nums2[j]
            ) {
                gtElement[j] = stk.peek();
                stk.push(nums2[j]);
            } else {
                if (!stk.isEmpty() &&
                        stk.peek() < nums2[j]
                ) {
                    while (!stk.isEmpty() &&
                            stk.peek() < nums2[j]
                    ) {
                        stk.pop();
                    }
                    if (!stk.isEmpty()) {
                        gtElement[j] = stk.peek();
                    } else {
                        gtElement[j] = -1;
                    }
                    stk.push(nums2[j]);
                }
            }
        }
        int[] output = new int[nums1.length];
        for (int k = 0 ; k < nums1.length; k++) {
            int idx = hmap.get(nums1[k]);
            output[k] = gtElement[idx];
        }
        return output;
    }
}
