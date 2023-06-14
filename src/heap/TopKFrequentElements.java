package heap;

import java.util.*;

public class TopKFrequentElements {

    /**
     *  https://leetcode.com/problems/top-k-frequent-elements/
     *  Input: nums = [1,1,1,2,2,3], k = 2
     *  Output: [1,2]
     * */


    public static void main(String[] args) {
        int[] input = {1,1,1,2,2,3};

        int[] output = topKelements(input, 2);

    }

    public static int[] topKelements(int[] arr, int k) {

        Map<Integer, Integer> hmap = new HashMap<>();
        for (int val :
             arr) {
            hmap.put(val, hmap.getOrDefault(val, 0) + 1);
        }

        List<Integer> bucket[] = new ArrayList[arr.length + 1];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> hmap.get(b) - hmap.get(a));

        for (int x:
             hmap.keySet()) {
            maxHeap.add(x);
        }

        int[] res = new int[k];
        for (int j = 0 ; j < k; j++) {
            res[j] = maxHeap.poll();
        }
        return res;
    }
}

