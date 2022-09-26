package arrays.windowsliding;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    /*
     *  https://leetcode.com/problems/longest-substring-without-repeating-characters/
     *  Input: s = "abcabcbb"
     *  Output: 3
     *  Explanation: The answer is "abc", with the length of 3.
     * */

    public static void main(String[] args) {
        String s = "abcabcbb";
        int output = longestSubstringWithoutUniqueCharacters(s);
        System.out.println(output);
    }

    private static int longestSubstringWithoutUniqueCharacters(String s) {
        int i = 0;
        int j = 0;
        int res = -1;
        HashMap<Character, Integer> hm = new HashMap<>();
        while (j < s.length()) {
            int window = (j-i+1);
            hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0) + 1);
            if (hm.size() == (j-i+1)) {
                res = Math.max(res, (j-i+1));
                j++;
            }

            if (hm.size() < window) {
                while (hm.size() < (j-i+1)) {
                    hm.put(s.charAt(i), hm.get(s.charAt(i)) - 1);
                    if (hm.get(s.charAt(i)) == 0) {
                        hm.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        return res;
    }
}
