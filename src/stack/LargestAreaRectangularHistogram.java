package stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestAreaRectangularHistogram {


    public static void main(String[] args) {
        // based on nearest smallest element to left and right
        int[] histogram = {6, 2, 5, 4, 5, 1, 6};
        Pair[] right = nearestSmallestElementToRight(histogram, histogram.length);
        Pair[] left = nearestSmallestElementToLeft(histogram, histogram.length);

        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < histogram.length ; i++) {
            int width = right[i].index - left[i].index - 1;
            int height = histogram[i];
            int area  = height*width;
            if (max < area) {
                max = area;
            }
        }
        System.out.println(max);

    }

    private static Pair[] nearestSmallestElementToRight(int[] arr, int n) {
        Stack<Pair> stk = new Stack<>();
        Pair[] output = new Pair[n];

        for (int i = n - 1; i >= 0; i--) {
            if (stk.isEmpty()) {
                output[i] = new Pair(1, i);
            }

            if (!stk.isEmpty() && stk.peek().getElement() <= arr[i]) {
                output[i] = stk.peek();
            }

            if (!stk.isEmpty() && stk.peek().getElement() >= arr[i]) {
                while (!stk.isEmpty() && stk.peek().getElement() >= arr[i]) {
                    stk.pop();
                }
                if (stk.isEmpty()) {
                    output[i] = new Pair(1, i);
                } else {
                    output[i] = stk.peek();
                }
            }
            stk.push(new Pair(arr[i], i));
        }
        return output;
    }

    private static Pair[] nearestSmallestElementToLeft(int[] arr, int n) {
        Stack<Pair> stk = new Stack<>();
        Pair[] output = new Pair[n];

        for (int i = 0; i < n; i++) {
            if (stk.isEmpty()) {
                output[i] = new Pair(1, i);
            }

            if (!stk.isEmpty() && stk.peek().getElement() <= arr[i]) {
                output[i] = stk.peek();
            }

            if (!stk.isEmpty() && stk.peek().getElement() >= arr[i]) {
                while (!stk.isEmpty() && stk.peek().getElement() >= arr[i]) {
                    stk.pop();
                }
                if (stk.isEmpty()) {
                    output[i] = new Pair(1, i);
                } else {
                    output[i] = stk.peek();
                }
            }
            stk.push(new Pair(arr[i], i));
        }
        return output;
    }

    private static class Pair {
        int element;
        int index;

        Pair(int element, int index) {
            this.element = element;
            this.index = index;
        }

        public int getElement() {
            return element;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "element=" + element +
                    ", index=" + index +
                    '}';
        }
    }
}
