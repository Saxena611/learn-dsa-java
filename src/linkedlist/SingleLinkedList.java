package linkedlist;

import java.util.List;

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

    public static int countNumberOfElementsInALinkedList(Node head) {
        Node curr = head;
        int count = 0;
        while (curr != null) {
            count += 1;
            curr = curr.next;
        }
        return count;
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
            //System.out.println(curr.data);
            if(curr.next == null){
                break;
            }
            curr = curr.next;
        }
        curr.next = last;
        return head;
    }

    public static Node delHead(Node head){
        if(head == null){
            return null;
        }
        return head.next;
    }

    public static Node delTail(Node head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return null;
        }
        Node curr = head;
        while(curr.next.next != null){
            curr = curr.next;
        }
        curr.next = null;
        return head;

    }

    public static Node insertAtPosition(Node head,int pos,int data){
        Node temp = new Node(data);
        if(pos == 1) {
            temp.next = head;
            return temp;
        }
        Node curr = head;
        for(int i = 1; i <= pos - 2 && curr != null ; i++){
            curr = curr.next;
        }
        if(curr==null){
            // boundary condition handling
            // for position exceeding linked list length
            return head;
        }
        temp.next = curr.next; // linking the later part
        curr.next = temp; // linking the prior part
        /*
        * It is necessary to link the later part first
        * as if you will link the prior part first then you will lose
        * the track of the latter part of the linked list.
        * */
        return head;
    }

    public static int search(Node head, int x){
        int pos = 1;
        Node curr = head;
        while(curr != null){
            if(curr.data == x){
                return pos;
            }else{
                pos++;
                curr = curr.next;
            }
        }
        return -1;
    }

    public static Node reverse(Node head){
        Node curr = head;
        Node prev = null;

        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static Node reverseLinkedListUsingRecursion(Node head) {

        // base case
        if (head.next == null) {
            return head;
        }
        Node nHead = reverseLinkedListUsingRecursion(head.next);
        Node curr = head.next;

        curr.next = head;
        head.next = null;
        return nHead;

    }

    public static Node reverseLinkedListSecondApproach(Node curr, Node prev) {
        if (curr == null) {
            return prev;
        }
        
        Node nxt = curr.next;
        curr.next = prev;
        return reverseLinkedListSecondApproach(nxt, curr);
    }

    public static Node convertListToLinkedList(List<Integer> aList) {
        Node head = new Node(aList.get(0));

        for (int i = 1; i < aList.size() ; i++) {
            insertAtEnd(head, aList.get(i));
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(50);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
//        Node newHead = insertAtBeginning(head,40);
//        printLinkedList(newHead);
//        Node endHead = insertAtEnd(newHead,60);
//        printLinkedList(endHead);
//        head = delHead(head);
//        printLinkedList(head);
//        head = delTail(head);
//        printLinkedList(head);
        // Node reverseHead = reverse(head);
        // printLinkedList(reverseHead);

//        Node revHead = reverseLinkedListUsingRecursion(head);
//        printLinkedList(revHead);

        Node rev2head = reverseLinkedListSecondApproach(head, null);
        printLinkedList(rev2head);
    }

}
