package linkedlist;

public class CountNodesInLoop {


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

        int lengthOfLoopInLinkedList = lengthOfLoopInLinkedList(n1);

        System.out.println(lengthOfLoopInLinkedList);
    }


    /**
     * 1. Find the common point in the loop by using the Floyd’s Cycle detection algorithm
     * 2. Store the pointer in a temporary variable and keep a count = 0
     * 3. Traverse the linked list until the same node is reached again and increase the count while moving to next node.
     * 4. Print the count as length of loop
     */
    public static int lengthOfLoopInLinkedList(SingleLinkedList.Node head) {

        SingleLinkedList.Node fast = head;
        SingleLinkedList.Node slow = head;

        // Floyd's cycle detection algorithm
        while (fast.next != null && fast.next.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {

                SingleLinkedList.Node temp = slow;
                int count = 1;

                while (temp.next != slow) {
                    count += 1;
                    temp = temp.next;
                }
                return count;
            }

        }
        return 0;
    }
}
