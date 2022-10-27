package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesFromSortedLinkedList {


    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<>(Arrays.asList(10,20,20,20,30,30,30,30,40,50,50));
        SingleLinkedList.Node head = SingleLinkedList.convertListToLinkedList(aList);
        SingleLinkedList.Node nHead = removeDuplicates(head);
        SingleLinkedList.printLinkedList(nHead);
    }

    private static SingleLinkedList.Node removeDuplicates(SingleLinkedList.Node head) {
        SingleLinkedList.Node curr = head;
        while (curr.next != null ) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }


}
