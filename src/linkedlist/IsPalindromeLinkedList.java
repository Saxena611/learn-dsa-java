package linkedlist;

public class IsPalindromeLinkedList {


    public static void main(String[] args) {
        // 1 2 3 3 2 1

        SingleLinkedList.Node n1 = new SingleLinkedList.Node(1);
        SingleLinkedList.Node n2 = new SingleLinkedList.Node(2);
        SingleLinkedList.Node n3 = new SingleLinkedList.Node(3);
        SingleLinkedList.Node n4 = new SingleLinkedList.Node(3);
        SingleLinkedList.Node n5 = new SingleLinkedList.Node(2);
        SingleLinkedList.Node n6 = new SingleLinkedList.Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;


        boolean isPalindrome = isPalindromeLinkedList(n1);

        System.out.println(isPalindrome);
    }

    public static boolean isPalindromeLinkedList(SingleLinkedList.Node head) {
        if ((head == null) && (head.next != null)) {
            return true;
        }

        SingleLinkedList.Node slow = head;
        SingleLinkedList.Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverseLinkedList(slow.next);
        slow = slow.next;

        while (slow != null) {
            if (head.data != slow.data) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public static SingleLinkedList.Node reverseLinkedList(SingleLinkedList.Node head) {

        SingleLinkedList.Node curr = head;
        SingleLinkedList.Node prev = null;

        while (curr != null) {
            SingleLinkedList.Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }


}
