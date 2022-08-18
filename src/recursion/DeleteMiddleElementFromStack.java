package recursion;

import java.util.Arrays;
import java.util.Stack;

public class DeleteMiddleElementFromStack {

    Stack<Integer> stack;

    public static void main(String[] args) {
        DeleteMiddleElementFromStack deleteMiddleElementFromStack = new DeleteMiddleElementFromStack();
        deleteMiddleElementFromStack.stack = new Stack<>();
        deleteMiddleElementFromStack.stack.addAll(Arrays.asList(2,3,7,5,4,9));
        System.out.println("Printing stack before removal of middle element: " + deleteMiddleElementFromStack.stack);
        int mid = (deleteMiddleElementFromStack.stack.size()/2) + 1;
        deleteMiddleElementFromStack.deleteMiddleElement(mid);
        System.out.println("Printing stack after removal of middle element: " + deleteMiddleElementFromStack.stack);
    }

    private void deleteMiddleElement(int mid) {
        if(mid == 1 && !stack.isEmpty()){
            stack.pop();
            return;
        }

        int temp = stack.pop();
        deleteMiddleElement(mid-1);
        stack.push(temp);
    }
}
