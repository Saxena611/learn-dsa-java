package recursion;

import java.util.Arrays;
import java.util.Stack;

public class ReverseAStack {

    Stack<Integer> stack;

    public static void main(String[] args) {
        ReverseAStack ReverseAStack = new ReverseAStack();
        ReverseAStack.stack = new Stack<>();
        ReverseAStack.stack.addAll(Arrays.asList(2,3,7,5,4,9));
        System.out.println(ReverseAStack.stack);
        ReverseAStack.reverseStack();
        System.out.println(ReverseAStack.stack);
    }

    private void reverseStack() {
        if (stack.isEmpty()){
            return;
        }
        int temp = stack.pop();
        reverseStack();
        insertAtLast(temp);
    }

    private void insertAtLast(int element){
        if(stack.isEmpty()){
            stack.push(element);
            return;
        }
        int temp = stack.pop();
        insertAtLast(element);
        stack.push(temp);
    }

}
