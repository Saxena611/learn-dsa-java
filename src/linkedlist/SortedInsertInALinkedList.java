package linkedlist;

import java.util.Arrays;
import java.util.List;

public class SortedInsertInALinkedList {
    
    public static void main(String[] args) {
        List<Integer> aList = Arrays.asList(10, 20, 30, 40, 50);
        SingleLinkedList.Node head = SingleLinkedList.convertListToLinkedList(aList);
        int element = 25;
        SingleLinkedList.Node outputHead = sortedInsertInALinkedList(head, element);
        SingleLinkedList.printLinkedList(outputHead);
    }

    private static SingleLinkedList.Node sortedInsertInALinkedList(SingleLinkedList.Node head, int element) {
        SingleLinkedList.Node nNode = new SingleLinkedList.Node(element);
        SingleLinkedList.Node curr = head;
        while (curr != null && curr.next.data < element) {
            curr = curr.next;
        }
        SingleLinkedList.Node temp = curr.next;
        curr.next = nNode;
        nNode.next = temp;
        return head;
    }
}
