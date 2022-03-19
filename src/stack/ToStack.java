package stack;

import java.util.ArrayList;

public class ToStack {

    ArrayList<Integer> stk = new ArrayList<>();

    void push(int x){
        stk.add(x);
    }

    int pop(){
      int res = stk.get(stk.size() - 1);
      stk.remove(stk.size() - 1);
      return  res;
    }

    int peek(){
        return stk.get(stk.size() - 1);
    }

    int size(){
        return stk.size();
    }

    public static void main(String[] args) {
        ToStack mystck = new ToStack();
        mystck.push(10);
        mystck.push(20);
        mystck.push(30);
        int pop_element = mystck.pop();
        System.out.println("The popped element : " + pop_element);
        mystck.peek();
        System.out.println("The size of the element : " + mystck.size());
    }
}
