package stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {


    /**
     * The stock span problem is a financial problem where we have a series of N daily price quotes for a stock and we need to calculate the span of the stock’s price for all N days.
     * The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than its price on the given day.
     * <p>
     * Input: N = 7, price[] = [100 80 60 70 60 75 85]
     * Output: 1 1 1 2 1 4 6
     * Explanation: Traversing the given input span for 100 will be 1, 80 is smaller than 100 so the span is 1, 60 is smaller than 80 so the span is 1, 70 is greater than 60 so the span is 2 and so on. Hence the output will be 1 1 1 2 1 4 6.
     */
    public static void main(String[] args) {
        int price[] = {100 ,80 ,60 ,70 ,60 ,75 ,85};
        int n = price.length;
        int[] output = stockSpan(price, n);
        System.out.println(Arrays.toString(output));
    }

    private static int[] stockSpan(int[] price, int n) {
        Stack<Pair> stack = new Stack<>();
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                output[i] = 1;
            }
            if (!stack.isEmpty() && stack.peek().getElement() >= price[i]) {
                output[i] = (i - stack.peek().getIndex());
            }
            if (!stack.isEmpty() && stack.peek().getElement() <= price[i]) {
                while (!stack.isEmpty() && stack.peek().getElement() < price[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    output[i] = 1;
                } else {
                    output[i] = (i - stack.peek().getIndex());
                }
            }
            stack.push(new Pair(price[i], i));
        }
        return output;
    }

    // Relative Problem
    private static int[] nextGreaterElementToTheLeft(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                output[i] = -1;
            }
            if (!stack.isEmpty() && stack.peek() >= arr[i]) {
                output[i] = stack.peek();
            }
            if (!stack.isEmpty() && stack.peek() <= arr[i]) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    output[i] = -1;
                } else {
                    output[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
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
    }


}
