package arrays.windowsliding;

import java.util.HashMap;
import java.util.Map;

public class CountSubstrings {

    /***
     * https://practice.geeksforgeeks.org/problems/count-substring/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=count-substring
     *
     * Input:
     * abcabc
     * Output:
     * 10
     * Explanation:
     * The required substrings  are "abc", "abca", "abcab", "abcabc",
     * "bca", "bcab", "bcabc", "cab", "cabc" and "abc".
     *
     */


    public static void main(String[] args) {
        String s = "abcabc";
        int n = s.length();
        System.out.println(countSubstrings(n, s));
    }

    private static int countSubstrings(int n, String s) {
        int i = 0;
        int j = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] sarr = s.toCharArray();
        while (j < n) {
            map.put(sarr[j], map.getOrDefault(sarr[j], 0) + 1);
            if (map.size() == 3) {
                while (map.size() == 3) {
                    count += n - j; // main logic 
                    map.put(sarr[i], map.get(sarr[i]) - 1);
                    if (map.get(sarr[i]) == 0) {
                        map.remove(sarr[i]);
                    }
                    i++;
                }

            }
            j++;
        }
        return count;
    }
}
