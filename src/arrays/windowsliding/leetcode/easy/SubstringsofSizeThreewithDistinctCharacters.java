package arrays.windowsliding.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class SubstringsofSizeThreewithDistinctCharacters {



    /**
     * LeetCode problem:
     * https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
     *
     * Level:
     * Easy
     *
     * Tags:
     * Sliding-window
     *
     * A string is good if there are no repeated characters.
     *
     * Given a string  return the number of good substrings of length three.
     *
     * Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
     *
     * A substring is a contiguous sequence of characters in a string.
     *
     * Input: s = "xyzzaz"
     * Output: 1
     * Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
     * The only good substring of length 3 is "xyz".
     *
     * */


    public static void main(String[] args) {
        String s = "xyzzaz";
        int output = substringCountWithThreeDistinctCharacter(s);
        System.out.println(output);
    }


    /**
     * Accepted code: https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/submissions/859472155/
     * */
    private static int substringCountWithThreeDistinctCharacter(String s) {
        // Applying sliding-window technique
        int i = 0; // start
        int j = 0; // end
        int k = 3; // fixed window size
        int output = 0;
        HashMap<Character, Integer> hmap = new HashMap<>(); // map to store distinct count.
        while (j < s.length()) {
            hmap.put(s.charAt(j), hmap.getOrDefault(s.charAt(j), 0) + 1);
            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {
                if (hmap.size() == k) {
                    // check if all element frequency equals to 1.
                    boolean isUnique = true;
                    for (Map.Entry<Character, Integer> entry: hmap.entrySet()) {
                        if (entry.getValue() != 1) {
                            isUnique = false;
                            break;
                        }
                    }
                    if (isUnique) {
                       output++;
                    }
                }
                // removing start calculations.
                hmap.put(s.charAt(i), hmap.getOrDefault(s.charAt(i), 1) - 1);
                int val = hmap.getOrDefault(s.charAt(i), 0);
                if (val == 0) {
                    hmap.remove(s.charAt(i));
                }

                i++;
                j++;
            }
        }
        return output;
    }
}
