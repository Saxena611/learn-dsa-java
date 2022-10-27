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

    public static Node insertAtPos(Node head, int data, int pos) {
        Node nNode = new Node(data);
        if (head == null) {
            return head;
        }

        if (head.next == null) {
            head.next = nNode;
            nNode.prev = head;
            return head;
        }

        Node curr = head;
        int currPos = 0; // considers 0-based indexing
        while (currPos < pos && curr.next != null) {
            currPos += 1;
            curr = curr.next;
        }

        // If element needs to be inserted at the end of the doubly linked list
        if(curr.next == null){
            curr.next = nNode;
            nNode.prev = curr;
            return head;
        }

        nNode.next = curr.next;
        curr.next.prev = nNode;
        curr.next = nNode;
        nNode.prev = curr;
        return head;

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
        Node n3 = new Node(60);

        // Logic to link doubly linked list
        head.next = n1;
        n1.prev = head;
        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;

        //head = insertAtBeginning(head, 40);
        //head = insertAtEnd(head , 50);
        head = insertAtPos(head, 25, 2);
        printList(head);
    }
}
