package heap;

import java.util.*;

public class SortArrayBasedOnFrequency {

    /**
     * Input: arr[] = {2, 2, 4, 5, 12, 2, 3, 3, 12}
     * Output: 3 3 3 3 2 2 2 12 12 4 5
     */
    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 4, 5, 12, 2, 3, 3, 12};

        List<Integer> output = sortArrayBasedOnFreqency(arr);

        System.out.println(output);
    }

    private static List<Integer> sortArrayBasedOnFreqency(int[] arr) {
        Map<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int val = hmap.computeIfAbsent(arr[i], s -> new Integer(0));
            hmap.put(arr[i], val + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((m1, m2) -> {
            if (m1.getValue() == m2.getValue()) {
                return m1.getKey() - m2.getKey(); // follow natural ordering.
            } else {
                return m2.getValue() - m1.getValue();
            }
        });

        pq.addAll(hmap.entrySet());

        List<Integer> output = new ArrayList<>();

        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> mentry = pq.poll();
            int freq = mentry.getValue();
            while (freq > 0) {
                output.add(mentry.getKey());
                freq -= 1;
            }
        }
        return output;
    }
}
