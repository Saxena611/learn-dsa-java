package arrays;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWith0Sum {

    /**
     * https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum/
     * <p>
     * Input Format: N = 6, array[] = {9, -3, 3, -1, 6, -5}
     * <p>
     * Result: 5
     * <p>
     * Explanation: The following subarrays sum to zero:
     * {-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
     * Since we require the length of the longest subarray, our answer is 5!
     */

    public static void main(String[] args) {
        int[] arr = {9, -3, 3, -1, 6, -5};
        System.out.println(maxLenSubArrayWithZeroSum(arr));
    }

    // O(N) time complexity with O(N) space.
    private static int maxLenSubArrayWithZeroSum(int[] arr) {
        int sum = 0;
        int maxLen = Integer.MIN_VALUE;
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (sum == 0) {
                maxLen = i + 1;
            }

            if (hmap.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - hmap.get(sum));
            } else {
                hmap.put(sum, i);
            }
        }
        return maxLen;
    }
}
