package strings;

import java.util.HashMap;
import java.util.Map;

public class SubstringWithAtMostKUniqueCharacters {
    /**
     * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/count-of-substrings-having-at-most-k-unique-characters-official/ojquestion
     *
     * */

    public static void main(String[] args) {
        String s = "aba";
        int k = 2;
        int o1 = substringWithAtMostKUniqueCharacters(s, k);
        int o2 = substringWithAtMostKUniqueCharacters(s, k - 1);
        System.out.println(o1-o2); // For exactly K unique characters.
        
    }

    public static int substringWithAtMostKUniqueCharacters(String str, int k) {
        Map<Character, Integer> hmap = new HashMap<>();
        int j = 0;
        int output = 0;
        for (int i = 0; i < str.length(); i++) {
            hmap.put(str.charAt(i), hmap.getOrDefault(str.charAt(i), 0) + 1);
            while (hmap.size() > k) {
                hmap.put(str.charAt(j), hmap.get(str.charAt(j)) - 1);
                if (hmap.get(str.charAt(j)) == 0) {
                    hmap.remove(str.charAt(j));
                }
                j++;
            }

            output += (i - j + 1);
        }
        return output;
    }

    /**
     * More optimized code with same algorithm.
     * */
    long subStringAtMostK(String s, int k) {
        int i=0,j=0,size=0,n=s.length();
        long ans=0;
        int[] map = new int[26];
        while(j<n) {
            char cha = s.charAt(j);
            if(map[cha-'a']==0) size++;
            map[cha-'a']++;
            while(size>k) {
                char chr = s.charAt(i);
                map[chr-'a']--;
                if(map[chr-'a']==0) size--;
                i++;
            }
            ans+=j-i+1;
            j++;
        }
        return ans;
    }


}
