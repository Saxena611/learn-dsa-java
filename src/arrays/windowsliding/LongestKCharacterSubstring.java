package arrays.windowsliding;

import java.util.HashMap;
import java.util.Map;

public class LongestKCharacterSubstring {

    /*
    *  https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
    *  Input:
    *  S = "aabacbebebe", K = 3
    *  Output: 7
    *  Explanation: "cbebebe" is the longest
    *  substring with K distinct characters.
    *
    *
    * Similar problems,
    * Pick toys,
    * Fruit baskets - https://practice.geeksforgeeks.org/problems/fruit-into-baskets-1663137462/1
    * */


    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        int output = longestKCharacterSubstring(s, k);
        System.out.println(output);
    }

    public static int longestKCharacterSubstring(String s, int k) {
        int i = 0;
        int j = 0;
        int res = -1;
        HashMap<Character, Integer> hm = new HashMap<>();
        while (j < s.length()) {
            hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0) + 1);
            if (hm.size() < k) {
                j++;
            }
            if (hm.size() == k) {
                res = Math.max(res, (j-i+1));
                j++;
            }

            if (hm.size() > k) {
                while (hm.size() > k) {
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
