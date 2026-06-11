import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class LinkedList {
    
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    public LinkedList(int value) {
        head = tail = new Node(value);
        length++;
    }

    public void append(int value) {
        if (length == 0)
            head = tail = new Node(value);
        else
            tail.next = tail = new Node(value);
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0)
            return null;
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node removeFirst() {
        if (length == 0)
            return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length)
            return null;
        else {
            Node tNode = head;
            for (int i = 0; i < index; i++) {
                tNode = tNode.next;
            }
            return tNode;
        }
    }

    public boolean set(int index, int value) {
        Node tempNode = get(index);
        if (tempNode == null)
            return false;
        else {
            tempNode.value = value;
            return true;
        }
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length)
            return false;

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node tempNode = get(index - 1);
        Node newNode = new Node(value);
        newNode.next = tempNode.next;
        tempNode.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length)
            return null;

        if (index == 0) {
            return removeFirst();
        }

        if (index == length - 1) {
            return removeLast();
        }

        Node prevNode = get(index - 1);
        Node tempNode = prevNode.next;
        prevNode.next = tempNode.next;
        tempNode.next = null;
        length--;
        return tempNode;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    public Node findKthFromEnd(int k) {
        // +===================================================+
        // | WRITE YOUR CODE HERE |
        // | Description: |
        // | - Finds the k-th node from the end of a singly |
        // | linked list. |
        // | - Returns the node at that position or null if |
        // | `k` is invalid or exceeds the list length. |
        // | |
        // | Behavior: |
        // | - Uses two pointers, `fast` and `slow`, starting |
        // | at the head of the list. |
        // | - Moves `fast` forward `k` nodes ahead of `slow`. |
        // | - Then moves both pointers together until `fast` |
        // | reaches the end. |
        // | - At that point, `slow` points to the k-th node |
        // | from the end and is returned. |
        // +===================================================+

        // 4 -> 1 -> 5 -> 1

        if (head == null || k <= 0)
            return null;

        Node fast = head;
        Node slow = head;

        for (int i = 1; i <= k; i++) {
            fast = fast.next;
            if (fast == null && i < k) {
                return null;
            }
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public void removeDuplicates() {
        Set<Integer> seen = new HashSet<>();

        Node current = head;
        if (head != null) {
            seen.add(current.value);

            while (current.next != null) {
                if (seen.contains(current.next.value)) {
                    current.next = current.next.next;
                } else {
                    seen.add(current.next.value);
                    current = current.next;
                }
            }
        }
    }

    public void partitionList(int x) {
        if (head == null)
            return;

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;

        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }

        prev2.next = null;
        prev1.next = dummy2.next;

        head = dummy1.next;
    }

    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null)
            return;

        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }

        Node currentNode = previousNode.next;

        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }

        head = dummyNode.next;
    }

    public void swapInPais() {

        if(head == null) return;

        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;
        Node first = prev.next;

        while (first != null && first.next != null) {
            Node second = first.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
            first = first.next;
        }

        head = dummy.next;


    }

}