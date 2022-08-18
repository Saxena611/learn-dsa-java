package recursion;

import java.util.Arrays;
import java.util.Stack;

public class SortStackUsingRecursion {

    public Stack<Integer> stack;

    public static void main(String[] args) {
        SortStackUsingRecursion stkObj = new SortStackUsingRecursion();
        stkObj.stack = new Stack<>();
        stkObj.stack.addAll(Arrays.asList(2,3,7,5,4,9));
        System.out.println("Unsorted Stack : " + stkObj.stack);

        stkObj.sortStack();

        System.out.println("Sorted Stack: " + stkObj.stack.toString());

    }

    private void sortStack() {
        if(stack.isEmpty() || stack.size() == 1){
            return;
        }

        int temp = stack.pop();
        sortStack();

        insertSortedElement(temp);
    }

    private void insertSortedElement(int element) {
        if (stack.isEmpty() || stack.peek() <= element){
            stack.push(element);
            return;
        }

        int value = stack.pop();
        insertSortedElement(element);

        stack.push(value);
    }
}
