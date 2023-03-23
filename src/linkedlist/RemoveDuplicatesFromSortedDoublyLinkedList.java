package linkedlist;

import linkedlist.DoublyLinkedList.Node;

public class RemoveDuplicatesFromSortedDoublyLinkedList {


    public static void main(String[] args) {
        // 1<->1<->1<->2<->3<->4
        DoublyLinkedList.Node head = new DoublyLinkedList.Node(1);
        DoublyLinkedList.Node n1 = new DoublyLinkedList.Node(1);
        DoublyLinkedList.Node n2 = new DoublyLinkedList.Node(1);
        DoublyLinkedList.Node n3 = new DoublyLinkedList.Node(2);
        DoublyLinkedList.Node n4 = new DoublyLinkedList.Node(3);
        DoublyLinkedList.Node n5 = new DoublyLinkedList.Node(4);

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
        
        System.out.println("Printing doubly linked list before duplicate element removal..");
        DoublyLinkedList.printList(head);
        Node newHead = removeDuplicates(head);
        System.out.println("Printing after removing duplicates..from sorted doubly linked list.");
        DoublyLinkedList.printList(newHead);

    }

    static Node removeDuplicates(Node head) {
        // Code Here.

        if (head == null) {
            return head;
        }

        Node curr = head;

        while (curr.next != null) {
            if (curr.data == curr.next.data) {
                deleteNode(head, curr.next);
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    static Node deleteNode(Node head, Node del) {
        if (head == null || del == null) {
            return head;
        }

        if (head == del) {
            head = del.next;
            return head;
        }

        if (del.next != null) {
            del.next.prev = del.prev;
        }

        if (del.prev != null) {
            del.prev.next = del.next;
        }
        return head;
    }
}
