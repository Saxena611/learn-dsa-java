package linkedlist;

import linkedlist.DoublyLinkedList.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPairWithGivenSumInSortedDoublyLinkedList {


    public static void main(String[] args) {
        // 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9 (distinct elements)
        DoublyLinkedList.Node head = new DoublyLinkedList.Node(1);
        DoublyLinkedList.Node n1 = new DoublyLinkedList.Node(2);
        DoublyLinkedList.Node n2 = new DoublyLinkedList.Node(4);
        DoublyLinkedList.Node n3 = new DoublyLinkedList.Node(5);
        DoublyLinkedList.Node n4 = new DoublyLinkedList.Node(6);
        DoublyLinkedList.Node n5 = new DoublyLinkedList.Node(8);
        DoublyLinkedList.Node n6 = new DoublyLinkedList.Node(9);

        // Logic to link doubly linked list
        head.next = n1;
        n1.prev = head;
        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        n3.next = n4;
        n4.prev = n3;
        n4.next = n5;
        n5.prev = n4;
        n5.next = n6;
        n6.prev = n5;

        DoublyLinkedList.printList(head);
        System.out.println(findPairWithGivenSumInDoublyLinkedList(head, 7));

    }

    static ArrayList<ArrayList<Integer>> findPairWithGivenSumInDoublyLinkedList(Node head, int target) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        Node curr = head;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        while (curr != tail) {
            int sum = curr.data + tail.data;
            if (sum > target) {
                tail = tail.prev;
            } else if (sum < target) {
                curr = curr.next;
            } else {
                output.add(new ArrayList<>(Arrays.asList(curr.data, tail.data)));
                curr = curr.next;
            }
        }
        return output;
    }
}
