package linkedlist;

import java.util.Arrays;
import java.util.List;

public class PrintMiddleOfALinkedList {


    public static void main(String[] args) {
        List<Integer> aList = Arrays.asList(10, 20, 30, 40, 50, 60);
        SingleLinkedList.Node head = SingleLinkedList.convertListToLinkedList(aList);
        SingleLinkedList.Node outputHead = printMiddleOfLinkedListNonEfficient(head);
        SingleLinkedList.Node outputHeadEff = printMiddleOfLinkedListEfficient(head);

    }

    private static SingleLinkedList.Node printMiddleOfLinkedListEfficient(SingleLinkedList.Node head) {
        /**
         * Efficient approach using fast and slow references.
         * Logic here is fast node moves 2 twice of slow references.
         * Thus, when fast node reaches at the end of the linked list
         * then slow reference is exactly at the half way of the linked list.
         *
         * */


        SingleLinkedList.Node slow = head;
        SingleLinkedList.Node fast = head;


        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle element with efficient approach: " + slow.data);
        return head;
    }

    private static SingleLinkedList.Node printMiddleOfLinkedListNonEfficient(SingleLinkedList.Node head) {
        // Non-efficient solution - count the number of elements in the linked list
        //                        - reach out to the middle position and print it
        int elementCount = SingleLinkedList.countNumberOfElementsInALinkedList(head);
        int midElement = elementCount / 2;

        SingleLinkedList.Node curr = head;
        int count = 0;
        while (count < midElement) {
            count += 1;
            curr = curr.next;
        }
        System.out.println("Middle element is : " + curr.data);
        return head;
    }
}
