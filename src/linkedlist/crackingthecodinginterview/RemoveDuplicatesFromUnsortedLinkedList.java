package linkedlist.crackingthecodinginterview;

import java.util.HashSet;

public class RemoveDuplicatesFromUnsortedLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printLinkedList(Node head) {
        Node currNode = head;
        while (currNode != null) {
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
    }

    public static void removeDuplicateFromUnsortedLinkedList(Node head) {
        // Hash to store seen values
        HashSet<Integer> hs = new HashSet<>();

        /* Pick elements one by one */
        Node current = head;
        Node prev = null;
        while (current != null) {
            int curval = current.data;

            // If current value is seen before
            if (hs.contains(curval)) {
                prev.next = current.next;
            } else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(2);
        Node n5 = new Node(4);
        Node n6 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        System.out.println("----Printing linked list before removing all duplicates---");
        printLinkedList(n1);
        removeDuplicateFromUnsortedLinkedList(n1);
        System.out.println("----Printing linked list after removing all duplicates---");
        printLinkedList(n1);
    }
}
