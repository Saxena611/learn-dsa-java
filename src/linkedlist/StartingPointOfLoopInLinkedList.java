package linkedlist;

public class StartingPointOfLoopInLinkedList {


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

        SingleLinkedList.Node startingNode = startOfLoopInLinkedList(n1);

        System.out.println(startingNode.data);

    }


    /**
     * L1 is the distance to reach start point of the loop
     * L2 is the distance to reach the collision point.
     * n is the number of circular rotation the fast pointer may took inside cycle.
     * c is the length of cycle.
     *
     * distance covered by fast pointer = L1 + L2 + N*C
     * distance covered by slow pointer = L1 + L2
     *
     * Now , slow pointer is twice of fast pointer distance.
     * * * *  2(L1+L2) = (L1+L2) + N*C
     * * * *  L1 = N*C - L2
     * Thus, collision for entry and slow will be the distance travelled by slow pointer after collision
     * and entry.
     *
     *
     * */
    private static SingleLinkedList.Node startOfLoopInLinkedList(SingleLinkedList.Node head) {
        SingleLinkedList.Node fast = head;
        SingleLinkedList.Node slow = head;
        SingleLinkedList.Node entry = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                while (slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return slow;
            }
        }
        return null;
    }
}
