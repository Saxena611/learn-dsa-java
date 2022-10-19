package recursion;

import java.util.Arrays;
import java.util.Stack;

public class SortAStack {

    Stack<Integer> stack;

    public static void main(String[] args) {
        SortAStack stkObj = new SortAStack();
        stkObj.stack = new Stack<>();
        stkObj.stack.addAll(Arrays.asList(2,3,7,5,4,9));
        System.out.println("Unsorted Stack : " + stkObj.stack);

        stkObj.sortStack();

        System.out.println("Sorted Stack: " + stkObj.stack.toString());

    }

    private void sortStack() {
        // base condition
        if (stack.isEmpty() || stack.size() == 1) {
            return;
        }

        // hypothesis
        int temp = stack.pop();
        sortStack();

        // induction
        insert(temp);
    }

    private void insert(int temp) {

        if (stack.isEmpty() || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }

        int temp_re = stack.pop();
        insert(temp);

        stack.push(temp_re);
    }


}
