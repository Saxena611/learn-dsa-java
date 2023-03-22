package linkedlist;

public class SegregateOddEvenElementsInLinkedList {


    public static void main(String[] args) {
        // 17 15 8 9 2 4 6
        SingleLinkedList.Node n1 = new SingleLinkedList.Node(17);
        SingleLinkedList.Node n2 = new SingleLinkedList.Node(15);
        SingleLinkedList.Node n3 = new SingleLinkedList.Node(8);
        SingleLinkedList.Node n4 = new SingleLinkedList.Node(9);
        SingleLinkedList.Node n5 = new SingleLinkedList.Node(2);
        SingleLinkedList.Node n6 = new SingleLinkedList.Node(4);
        SingleLinkedList.Node n7 = new SingleLinkedList.Node(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        SingleLinkedList.Node nHead = segregateOddEventElements(n1);

        SingleLinkedList.printLinkedList(nHead);


    }

    public static SingleLinkedList.Node segregateOddEventElements(SingleLinkedList.Node head) {
        SingleLinkedList.Node even = null;
        SingleLinkedList.Node odd = null;
        SingleLinkedList.Node curr = head;
        SingleLinkedList.Node dummyEven = null;
        SingleLinkedList.Node dummyOdd = null;

        while (curr != null) {
            SingleLinkedList.Node nNode = new SingleLinkedList.Node(curr.data);
            if (curr.data % 2 == 0) {
                if (even == null) {
                    even = nNode;
                    dummyEven = even;
                } else {
                    even.next = nNode;
                    even = even.next;
                }
            } else {
                if (odd == null) {
                    odd = nNode;
                    dummyOdd = nNode;
                } else {
                    odd.next = nNode;
                    odd = odd.next;
                }
            }
            curr = curr.next;
        }

        // case where there are no even elements.
        if (even == null) {
            return dummyOdd;
        }

        // case where there are no odd elements.
        if (odd == null) {
            return dummyEven;
        }

        // both
        even.next = dummyOdd;
        return dummyEven;
    }
}
