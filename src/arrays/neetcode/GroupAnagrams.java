package arrays.neetcode;

import java.util.*;

public class GroupAnagrams {

    /**
     *  https://leetcode.com/problems/group-anagrams/
     *  Input: strs = ["eat","tea","tan","ate","nat","bat"]
     *  Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 
     * */

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // String[] strs = {"", ""};
        List<List<String>> groupedAnagram = groupAnagram(strs);
        System.out.println(groupedAnagram);
    }

    public static List<List<String>> groupAnagram(String[] strs) {
        HashMap<String, List<String>> hmap = new HashMap<>();
        for (int i = 0 ;  i < strs.length ; i++) {
            String in = strs[i];
            char[] inarr = in.toCharArray();
            Arrays.sort(inarr);
            String key = Arrays.toString(inarr);
            hmap.computeIfAbsent(key, s -> new ArrayList<>()).add(in);
        }
        List<List<String>> output = new ArrayList<>();
        hmap.forEach((k,v) -> output.add(v));
        return output;
    }
}
