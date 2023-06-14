package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElement {

    public static void main(String[] args) {

        int[] arr = {12, 16, 22, 30, 35, 39, 42,
                45, 48, 50, 53, 55, 56};

        int k = 4;
        int x = 35;

        System.out.println(getKClosestElements(arr, k, x));

    }

    public static List<Integer> getKClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            return Integer.compare(p2.getNumber(), p1.getNumber());
        });

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != x) {
                pq.add(new Pair(Math.abs(arr[i] - x), i));
            }
            while (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> output = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            output.add(arr[pair.getIndex()]);
        }
        return output;
    }

    static class Pair {
        int number;
        int index;

        public Pair(int number, int index) {
            this.number = number;
            this.index = index;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}
