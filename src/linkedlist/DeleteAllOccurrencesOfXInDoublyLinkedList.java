package linkedlist;

public class DeleteAllOccurrencesOfXInDoublyLinkedList {


    public static void main(String[] args) {
        // 2<->2<->10<->8<->4<->2<->5<->2
        DoublyLinkedList.Node head = new DoublyLinkedList.Node(2);
        DoublyLinkedList.Node n1 = new DoublyLinkedList.Node(2);
        DoublyLinkedList.Node n2 = new DoublyLinkedList.Node(10);
        DoublyLinkedList.Node n3 = new DoublyLinkedList.Node(8);
        DoublyLinkedList.Node n4 = new DoublyLinkedList.Node(4);
        DoublyLinkedList.Node n5 = new DoublyLinkedList.Node(2);
        DoublyLinkedList.Node n6 = new DoublyLinkedList.Node(5);
        DoublyLinkedList.Node n7 = new DoublyLinkedList.Node(5);

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
        n6.prev = n7;

        n6.next = n7;
        n7.prev = n6;

        DoublyLinkedList.Node h = deleteAllOccurrencesOfXInLinkedList(head, 2);
        DoublyLinkedList.printList(h);
    }

    public static DoublyLinkedList.Node deleteAllOccurrencesOfXInLinkedList(DoublyLinkedList.Node head, int x) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            if (head.data == x) {
                return head.next = null;
            } else {
                return head;
            }
        }
        DoublyLinkedList.Node curr = head;

        // main logic
        while (curr.next != null) {
            if (head.data == x) {
                head = head.next;
                head.prev = null;
            }else if (curr.data == x) {
                DoublyLinkedList.Node beforeNode = curr.prev;
                DoublyLinkedList.Node afterNode = curr.next;
                beforeNode.next = afterNode;
                afterNode.prev = beforeNode;
            }
            curr = curr.next;
        }
        if (curr.data == x) {
            DoublyLinkedList.Node last = curr.prev;
            last.next = null;
        }
        return head;
    }
}
