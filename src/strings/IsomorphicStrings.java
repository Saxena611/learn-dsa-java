package strings;

import java.util.HashMap;

public class IsomorphicStrings {

    /**
     * Given two strings 'str1' and 'str2', check if these two strings are isomorphic to each other.
     * Two strings str1 and str2 are called isomorphic
     * if there is a one to one mapping possible for every character of str1 to every character of str2 while preserving the order.
     * Note: All occurrences of every character in str1 should map to the same character in str2
     */

    public static void main(String[] args) {
        System.out.println(isIsomorphicStrings("aab", "xxy"));
    }

    /**
     * Input:
     * str1 = aab
     * str2 = xxy
     * Output: 1
     * Explanation: There are two different
     * characters in aab and xxy, i.e a and b
     * with frequency 2and 1 respectively.
     */
    public static boolean isIsomorphicStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Character> hmap = new HashMap<>();
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        for (int i = 0; i < str1.length(); i++) {
            if (hmap.containsKey(ch1[i])) {
                char c = hmap.get(ch1[i]);

                if (c != ch2[i]) {
                    return false;
                }

            } else if (!hmap.containsValue(ch2[i])) {
                hmap.put(ch1[i], ch2[i]);
            } else {
                return false; // For already mapped values. As there is one to one relationship.
            }
        }
        return true;
    }
}
