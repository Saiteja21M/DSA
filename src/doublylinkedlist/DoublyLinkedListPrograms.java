package doublylinkedlist;

import doublylinkedlist.DoublyLinkedList.Node;

public class DoublyLinkedListPrograms {
    public void reverse(DoublyLinkedList doublyLinkedList) {
        if (doublyLinkedList.getLength() <= 1)
            return;

        Node current = doublyLinkedList.getHead();
        doublyLinkedList.setHead(doublyLinkedList.getTail());
        doublyLinkedList.setTail(current);

        Node after = null;
        Node before = null;

        for (int i = 0; i < doublyLinkedList.getLength(); i++) {
            after = current.next;
            current.next = before;
            current.prev = after;
            before = current;
            current = after;
        }
    }

    public void partitionList(DoublyLinkedList doublyLinkedList, int x) {
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node lesser = dummy1;
        Node higher = dummy2;
        Node temp = doublyLinkedList.getHead();

        while (temp != null) {
            if (temp.value < x) {
                lesser.next = temp;
                temp.prev = lesser;
                lesser = temp;
            } else {
                higher.next = temp;
                temp.prev = higher;
                higher = temp;

            }
            temp = temp.next;
        }

        if (dummy1.next == null || dummy2.next == null)
            return;

        lesser.next = dummy2.next;
        dummy2.next.prev = lesser;
        doublyLinkedList.setHead(dummy1.next);
        doublyLinkedList.getHead().prev = null;
        higher.next = null;
        doublyLinkedList.setTail(higher);

    }

    public void reverseBetween(DoublyLinkedList doublyLinkedList, int startIndex, int endIndex) {

        Node head = doublyLinkedList.getHead();
        if (head == null || startIndex == endIndex) {
            return;
        }

        // Create a dummy node to simplify edge cases
        Node dummy = new Node(0);
        dummy.next = head;
        head.prev = dummy;

        // Step 1: Move 'prev' to the node before startIndex
        Node prev = dummy;
        for (int i = 0; i < startIndex; i++) {
            prev = prev.next;
        }

        // Step 2: Start reversing from 'current' = prev.next
        Node current = prev.next;

        // Step 3: Reverse by relocating nodes one at a time
        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = current.next;

            // Remove nodeToMove from its place
            current.next = nodeToMove.next;
            if (nodeToMove.next != null) {
                nodeToMove.next.prev = current;
            }

            // Move nodeToMove to the front of the sublist
            nodeToMove.next = prev.next;
            prev.next.prev = nodeToMove;

            prev.next = nodeToMove;
            nodeToMove.prev = prev;
        }

        // Step 4: Update head in case it changed
        doublyLinkedList.setHead(dummy.next);
        doublyLinkedList.getHead().prev = null;
    }

    public void swapInPairs(DoublyLinkedList doublyLinkedList) {
        Node head = doublyLinkedList.getHead();
        if (head == null)
            return;

        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;

        Node first = prev.next;

        while (first != null && first.next != null) {
            Node second = first.next;

            prev.next = second;
            first.next = second.next;
            first.prev = second;
            second.next = first;
            second.prev = prev;

            prev = first;
            first = first.next;
        }

        if (first != null) {
            first.prev = prev;
        }

        doublyLinkedList.setHead(dummy.next);
        if (doublyLinkedList.getHead() != null)
            doublyLinkedList.getHead().prev = null;
    }

    // =====================================================================
    // NEW PRACTICE EXERCISES (stubs only — fill in the logic yourself)
    // =====================================================================

    public boolean isPalindrome(DoublyLinkedList doublyLinkedList) {
        // +===================================================+
        // | EXERCISE: Palindrome Check |
        // | Description: |
        // | - Determine whether the values in this list read |
        // | the same forwards and backwards. |
        // | |
        // | Example: |
        // | 1 -> 2 -> 3 -> 2 -> 1 => true |
        // | 1 -> 2 -> 3 -> 4 => false |
        // | |
        // | Since each node already has a `prev` pointer, |
        // | think about whether you actually need extra |
        // | space here, or whether you can walk from both |
        // | ends (head forward, tail backward) at once. |
        // +===================================================+

        return false; // TODO: implement
    }

    public void rotateRight(DoublyLinkedList doublyLinkedList, int k) {
        // +===================================================+
        // | EXERCISE: Rotate List |
        // | Description: |
        // | - Rotate the list to the right by k places. |
        // | |
        // | Example: |
        // | 1 -> 2 -> 3 -> 4 -> 5, k = 2 |
        // | => 4 -> 5 -> 1 -> 2 -> 3 |
        // | |
        // | Edge cases to consider: |
        // | - k larger than the length of the list (k % len) |
        // | - k == 0 or an empty list |
        // | - remember to keep prev/next AND head/tail all |
        // | consistent, unlike the singly linked version. |
        // +===================================================+

        // TODO: implement
    }
}
