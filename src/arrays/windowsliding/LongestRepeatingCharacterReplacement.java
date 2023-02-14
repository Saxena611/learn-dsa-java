package arrays.windowsliding;

import java.util.Arrays;

public class LongestRepeatingCharacterReplacement {

    /**
     * https://leetcode.com/problems/longest-repeating-character-replacement/description/
     * Input: s = "ABAB", k = 2
     * Output: 4
     * Explanation: Replace the two 'A's with two 'B's or vice versa.
     *
     *
     * */


    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int[] count = new int[26]; // 26 upper case characters
        Arrays.fill(count, 0);
        int res = Integer.MIN_VALUE;
        int l = 0;
        char[] strArr = s.toCharArray();
        for (int r = 0 ; r < s.length(); r++) {
            // increment count for each character
            count[strArr[r]-'A']++;
            // Optimization: we can have a variable having max frequency and we can maintain max count at each character if
            // max character count will change automatically max value will get updated.

            // main logic
            // if the window size and its difference with max occuring character is less than or equal to k
            // then we are good to take the count of max len substring , otherwise we will have to shift towards the new sub-array
            // by sliding the window.
            while (((r-l+1) - getMaxValue(count)) > k ) {
                count[strArr[l]-'A']--;
                l++;
            }

            res = Math.max(res, (r - l + 1));
        }
        return res;
    }

    public static int getMaxValue(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0 ; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }
}
