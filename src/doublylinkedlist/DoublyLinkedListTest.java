package doublylinkedlist;

public class DoublyLinkedListTest {

    public static void main(String[] args) {

        DoublyLinkedListPrograms doublyLinkedListPrograms = new DoublyLinkedListPrograms();

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(1);

        // doublyLinkedList.printList();

        doublyLinkedList.append(2);

        // doublyLinkedList.printList();

        doublyLinkedList.prepend(0);

        // doublyLinkedList.printList();

        // // System.out.println("Get value by index: " +
        // doublyLinkedList.get(2).value);

        // // doublyLinkedList.removeFirst();

        // // doublyLinkedList.printList();

        // // doublyLinkedList.removeLast();

        // // doublyLinkedList.printList();

        // // doublyLinkedList.set(0, 0);

        // // doublyLinkedList.printList();

        // // System.out.println(doublyLinkedList.insert(1, 5));

        // // doublyLinkedList.printList();

        // System.out.println("Removed value: " + doublyLinkedList.remove(0).value);

        // doublyLinkedList.printList();

        // System.out.println("Prev value: " + doublyLinkedList.get(1).prev.value);

        // doublyLinkedList.append(3);

        // doublyLinkedList.printList();

        // doublyLinkedList.reverse();

        // doublyLinkedList.printList();

        // System.out.println(doublyLinkedList.get(1).next.value);

        // System.out.println(doublyLinkedList.getHead().prev);

        // System.out.println(doublyLinkedList.getTail().next);

        doublyLinkedList.set(0, 1);

        doublyLinkedList.append(4);

        doublyLinkedList.append(0);

        doublyLinkedList.append(5);

        // doublyLinkedList.printList();

        // doublyLinkedList.partitionList(2);

        // doublyLinkedList.printList();

        // System.out.println(doublyLinkedList.get(1).next.value);

        // doublyLinkedList.reverseBetween(2, 5);

        doublyLinkedList.removeLast();

        doublyLinkedList.printList();

        // doublyLinkedList.printList();

        doublyLinkedListPrograms.swapInPairs(doublyLinkedList);

        doublyLinkedList.print();

        doublyLinkedList.printReverse();
    }

}
