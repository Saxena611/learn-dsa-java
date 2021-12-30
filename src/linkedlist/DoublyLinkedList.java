package linkedlist;

/*
    Advantage and disadvantage of Doubly Linked List

    1. Doubly Linked Lust
        a. From any node you can traverse in both the directions
        b. Delete/Insert a node in O(1) .
        c. Insert a node before a node.
        d. Consumes extra space.
        e. Code becomes complex.

    2. Singly Linked List
        a. Simple data structure
        b. Time complexity is slightly greater than doubly.

 */

public class DoublyLinkedList {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int x) {
            this.data = x;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node insertAtBeginning(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        return newNode;
    }

    public static Node insertAtEnd(Node head,int data){
        Node newNode = new Node(data);
        if(head == null){
            return newNode;
        }
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.prev = curr;
        return head;
    }

    public static void printList(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node n1 = new Node(20);
        Node n2 = new Node(30);

        // Logic to link doubly linked list
        head.next = n1;
        n1.prev = head;
        n1.next = n2;
        n2.prev = n1;

        head = insertAtBeginning(head, 40);
        head = insertAtEnd(head , 50);
        printList(head);
    }
}
