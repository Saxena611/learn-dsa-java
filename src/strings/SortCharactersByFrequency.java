package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {


    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(sortCharactersByFrequency(s));
    }

    public static String sortCharactersByFrequency(String s) {
        char[] charr = s.toCharArray();
        HashMap<Character, Integer> hmap = new HashMap<>();


        for (char c : charr) {
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((m1, m2) -> {
            if (m1.getValue() == m2.getValue()) {
                return (m1.getKey() - 'a') - (m2.getKey() - 'a');
            }
            return m2.getValue() - m1.getValue();
        });

        maxHeap.addAll(hmap.entrySet());


        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();

            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
