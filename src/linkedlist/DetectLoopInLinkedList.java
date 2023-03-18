package linkedlist;

public class DetectLoopInLinkedList {


    public static void main(String[] args) {
        SingleLinkedList.Node n1 = new SingleLinkedList.Node(10);
        SingleLinkedList.Node n2 = new SingleLinkedList.Node(20);
        SingleLinkedList.Node n3 = new SingleLinkedList.Node(30);
        SingleLinkedList.Node n4 = new SingleLinkedList.Node(40);
        SingleLinkedList.Node n5 = new SingleLinkedList.Node(50);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        // creating a loop in linked list.
        n5.next = n3;

        boolean detectLoop = detectLoopInLinkedList(n1);

        System.out.println(detectLoop);

    }

    // Optimized approach using fast and slow pointer. O(1) space.
    // Another approach can be using hashmap. It will take an extra space. O(n) space.
    public static boolean detectLoopInLinkedList(SingleLinkedList.Node head) {

        SingleLinkedList.Node fast = head;
        SingleLinkedList.Node slow = head;
        while (fast.next != null && fast.next.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }

        }
        return false;
    }
}
