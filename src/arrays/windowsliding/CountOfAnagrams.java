package arrays.windowsliding;

import java.util.HashMap;

public class CountOfAnagrams {


    public static void main(String[] args) {
        /*
        * https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
        * Input:
          txt = forxxorfxdofr
          pat = for
          Output: 3
        *
        * */

        String s = "forxxorfxdofr";
        String window = "for";
        int output = countOfAnagrams(s, window);
        System.out.println(output);
    }


    public static int countOfAnagrams(String input, String word) {
        int i = 0;
        int j = 0;
        int ans = 0;

        HashMap<Character, Integer> hmap = new HashMap<>();
        for (int k = 0; k < word.length() ; k++) {
            hmap.put(word.charAt(k), hmap.getOrDefault(word.charAt(k), 0) + 1);
        }
        int count = hmap.size();



        while (j < input.length()) {
            if (hmap.containsKey(input.charAt(j))) {
                int value = hmap.get(input.charAt(j));
                if (value >= 0) {
                    hmap.put(input.charAt(j), value - 1);
                    value -= 1;
                }
                if (value == 0) {
                    count -= 1;
                }
            }

            if ((j - i + 1) < word.length()) {
                j++;
            } else if ((j - i + 1) == word.length()) {
                if (count == 0) {
                    ans += 1;
                }

                if (hmap.containsKey(input.charAt(i))) {
                        int val = hmap.get(input.charAt(i));
                        if (val <= 0) {
                            hmap.put(input.charAt(i), hmap.get(input.charAt(i)) + 1);
                            count += 1;
                        }
                }
                i++;
                j++;
            }
        }

        return ans;
    }
}
