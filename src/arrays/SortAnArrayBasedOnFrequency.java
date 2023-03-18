package arrays;

import java.util.*;

public class SortAnArrayBasedOnFrequency {


    public static void main(String[] args) {
        List<Integer> alist = Arrays.asList(5, 5, 4, 2, 4);
        System.out.println(sortArrayBasedOnFrequency(alist));
    }


    public static List<Integer> sortArrayBasedOnFrequency(List<Integer> integerList) {
        Map<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < integerList.size(); i++) {
            hmap.put(integerList.get(i), hmap.getOrDefault(integerList.get(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((m1, m2) -> {
            if (m1.getValue() == m2.getValue()) {
                return m1.getKey() - m2.getKey(); // Natural order
            } else {
                return m2.getKey() - m1.getKey(); // Descending order
            }
        });
        // Learning: We will not get sorted elements by printing the priority queue.
        maxHeap.addAll(hmap.entrySet());


        ArrayList<Integer> lst = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                lst.add(entry.getKey());
            }
        }
        return lst;
    }
}


//class CustomCom implements Comparator<Map.Entry<Integer, Integer>> {
//
//    public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) {
//        if (m1.getValue() == m2.getValue())
//            return m1.getKey() - m2.getKey();
//        else
//            return m2.getValue() - m1.getValue();
//    }
//}