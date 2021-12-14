package linkedlist;

public class SingleLinkedList {

    static class Node{
        int data;
        Node next;
        Node(int x){
            data = x;
            next = null;
        }
    }
    public static void printLinkedList(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + "-->");
            curr = curr.next;
        }
    }

    public static Node insertAtBeginning(Node head,int x){
        Node temp = new Node(x);
        temp.next = head;
        return temp;
    }

    public static Node insertAtEnd(Node head,int x){
        Node last = new Node(x);
        Node curr = head;
        while(curr != null){
            System.out.println(curr.data);
            if(curr.next == null){
                break;
            }
            curr = curr.next;
        }
        curr.next = last;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        head.next = temp1;
        temp1.next = temp2;
        Node newHead = insertAtBeginning(head,40);
        printLinkedList(newHead);
        Node endHead = insertAtEnd(newHead,50);
        printLinkedList(endHead);
        printLinkedList(endHead);
    }

}
