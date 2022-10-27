package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseLinkedListInGroupOfSizeK {

    public static void main(String[] args) {
        ArrayList<Integer> aList = new ArrayList<>(Arrays.asList(10, 20, 30,40, 50, 60));
        SingleLinkedList.Node head = SingleLinkedList.convertListToLinkedList(aList);
        SingleLinkedList.Node nHead = reverseLinkedListInGroups(head, 3);
        SingleLinkedList.printLinkedList(nHead);
    }

    private static SingleLinkedList.Node reverseLinkedListInGroups(SingleLinkedList.Node head, int k) {

        SingleLinkedList.Node curr = head;
        SingleLinkedList.Node prev = null;
        SingleLinkedList.Node next = null;

        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            SingleLinkedList.Node rest_head = reverseLinkedListInGroups(next, 3);
            head.next = rest_head;
        }
        return prev;

    }
}
