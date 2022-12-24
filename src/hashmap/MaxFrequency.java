package hashmap;

/*
You are given an array of integers that contain numbers in random order.
Write a program to find and return the number which occurs the maximum
times in the given input.
 */

import java.util.LinkedHashMap;

public class MaxFrequency {

    public static int maxFrequencyNumber(int[] arr) {
        int output = 0;
        // Linked hash map required to maintain the insertion order.
        LinkedHashMap<Integer, Integer> hmap = new LinkedHashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (hmap.containsKey(arr[i])) {
                hmap.put(arr[i], hmap.get(arr[i]) + 1);
            } else {
                hmap.put(arr[i], 1);
            }
        }



        int max = 0;
        for (Integer key : hmap.keySet()) {
            //System.out.print(key + ":" + hmap.get(key));
            if (hmap.get(key) > max) {
                max = hmap.get(key);
                output = key;
            }
        }

        return output;
    }
}
