package sorting;

import java.util.*;

public class MergeOverlappingIntervals {


    public static void main(String[] args) {
        Interval arr[] = { new Interval(5,10),new Interval(3,15),new Interval(18,30),
                new Interval(2,7) };
        mergeIntervals(arr);
        

//        List<Interval> intervalArrayList = Arrays.asList(arr);

//        Collections.sort(intervalArrayList, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.st - o2.st;
//            }
//        });


    }

    private static void mergeIntervals(Interval[] arr) {
        Arrays.sort(arr);
        int res = 0;
        for (int i = 1 ; i < arr.length ; i++) {

            if (arr[res].ed >= arr[i].st) {
                arr[res].st = Math.min(arr[res].st, arr[i].st);
                arr[res].ed = Math.max(arr[res].ed, arr[i].ed);
            } else {
                res += 1;
                arr[res] = arr[i];
            }

        }

        for (int i = 0; i <= res; i++)
            System.out.print(  "[" + arr[i].st + ", " + arr[i].ed + "] ");
    }

    private static class Interval implements Comparable<Interval> {
        private int st;
        private int ed;

        public Interval(int st, int ed) {
            this.st = st;
            this.ed = ed;
        }


        @Override
        public int compareTo(Interval o) {
            return st - o.st;
        }
    }
}
