package arrays.neetcode;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ContainsDuplicate {
    /**
     * https://leetcode.com/problems/contains-duplicate/
     * input: nums = [1,2,3,1]
     * output: true
     * */

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.print(solve(arr));
    }

    public static boolean solve(int[] arr) {

        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0 ; i < arr.length ; i++) {
            hmap.computeIfAbsent(arr[i],  s -> new Integer(0));
            hmap.computeIfPresent(arr[i], (k,v) -> v + 1);
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        hmap.forEach((k,v) -> {
            if(v > 1) {
             atomicBoolean.set(true);
            }
        });
        return atomicBoolean.get();
    }
}
