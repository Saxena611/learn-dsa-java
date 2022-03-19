package queue;

/*
    public interface Queue extends Collection
    1. can be implemented using linked list and priority queues

 */

import java.util.LinkedList;
import java.util.Queue;

public class ToQueue {

    // implementation using linked list
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        // print the top element of the queue
        System.out.println(queue.peek());
        // print and remove the top element of the queue
        System.out.println(queue.poll());
        // print the top of the queue again
        System.out.println(queue.peek());
    }


}
