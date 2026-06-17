package linkedlist;

public class LinkedListTest {

    public static void main(String[] args) {

        LinkedListPrograms linkedListPrograms = new LinkedListPrograms();

        LinkedList linkedList = new LinkedList(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.append(7);
        linkedList.append(8);
        // linkedList.printList();

        linkedList.removeLast();
        // linkedList.printList();

        linkedList.prepend(3);
        // linkedList.printList();

        linkedList.removeFirst();
        // linkedList.printList();

        // System.out.println(linkedList.get(3).value + "\n");

        // linkedList.printList();

        linkedList.remove(4);
        linkedList.printList();

        LinkedList linkedList1 = new LinkedList(1);
        linkedList1.append(2);
        linkedList1.append(3);
        linkedList1.append(4);
        linkedList1.append(5);
        linkedList1.append(6);

        linkedListPrograms.findKthFromEnd(linkedList, 1);

        // linkedList.removeDuplicates();
        linkedList.printList();

        // linkedList.partitionList(2);
        linkedList.printList();

        linkedList.append(6);

        LinkedList revLinkedList = new LinkedList(1);
        revLinkedList.append(2);
        revLinkedList.append(3);
        revLinkedList.append(4);
        revLinkedList.append(5);
        revLinkedList.append(6);
        revLinkedList.append(7);
        revLinkedList.printList();
        linkedListPrograms.reverseBetween(revLinkedList, 1, 3);
        revLinkedList.printList();
        linkedListPrograms.swapInPairs(revLinkedList);
        revLinkedList.printList();

        // Test 5: Multi-node, loop back to head
        System.out.println("Test 5: Multi-Node (Loop to Head)");
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.getTail().next = myLinkedList.getHead().next.next; // Loop to next of head
        System.out.println("1 -> 2 -> 3 -> 4 -> (loops back to 3)");
        System.out.println("Expected: true");
        System.out.println("Actual: " + linkedListPrograms.hasCycle(myLinkedList));
        System.out.println();
        System.out.println("Cycle start: " + linkedListPrograms.detectCycleStart(myLinkedList).value);

    }

}
