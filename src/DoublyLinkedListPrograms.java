public class DoublyLinkedListPrograms {

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(1);

        doublyLinkedList.printList();

        doublyLinkedList.append(2);

        doublyLinkedList.printList();

        doublyLinkedList.prepend(0);

        doublyLinkedList.printList();

        // System.out.println("Get value by index: " + doublyLinkedList.get(2).value);

        // doublyLinkedList.removeFirst();

        // doublyLinkedList.printList();

        // doublyLinkedList.removeLast();

        // doublyLinkedList.printList();

        // doublyLinkedList.set(0, 0);

        // doublyLinkedList.printList();

        // System.out.println(doublyLinkedList.insert(1, 5));

        // doublyLinkedList.printList();

        System.out.println("Removed value: " + doublyLinkedList.remove(0).value);

        doublyLinkedList.printList();

        System.out.println("Prev value: " + doublyLinkedList.get(1).prev.value);
    }

}
