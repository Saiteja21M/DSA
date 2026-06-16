import lombok.Data;

@Data
public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        head = tail = new Node(value);
        length++;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "\t");
            temp = temp.next;
        }

        System.out.println();
    }

    public void append(int value) {
        Node node = new Node(value);
        if (length == 0)
            head = tail = node;
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        length++;
    }

    public void prepend(int value) {

        Node node = new Node(value);

        if (length == 0) {
            head = tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }

        length++;
    }

    public Node removeLast() {
        if (length == 0)
            return null;

        Node temp = tail;

        if (length == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }

        length--;
        return temp;
    }

    public Node removeFirst() {

        if (length == 0)
            return null;

        Node temp = head;

        if (length == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }

        length--;

        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length)
            return null;
        Node temp = head;
        if (index < length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value) {

        Node node = get(index);

        if (node != null) {
            node.value = value;
            return true;
        }

        return false;
    }

    public boolean insert(int index, int value) {

        if (index < 0 || index > length) {
            return false;
        }

        if (index == 0) {
            prepend(value);
        } else if (index == length) {
            append(value);
        } else {
            Node node = new Node(value);
            Node cuNode = get(index);
            node.next = cuNode;
            node.prev = cuNode.prev;
            cuNode.prev.next = node;
            cuNode.prev = node;
            length++;
        }

        return true;
    }

    public Node remove(int index) {

        if (index < 0 || index >= length) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        } else if (index == length - 1) {
            return removeLast();
        } else {
            Node cuNode = get(index);
            cuNode.prev.next = cuNode.next;
            cuNode.next.prev = cuNode.prev;
            cuNode.prev = null;
            cuNode.next = null;
            length--;
            return cuNode;
        }
    }

    public void reverse() {
        if (length <= 1)
            return;

        Node current = head;
        head = tail;
        tail = current;

        Node after = null;
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = current.next;
            current.next = before;
            current.prev = after;
            before = current;
            current = after;
        }
    }

    public void partitionList(int x) {
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node lesser = dummy1;
        Node higher = dummy2;
        Node temp = head;

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
        head = dummy1.next;
        head.prev = null;
        higher.next = null;
        tail = higher;

    }

    public void reverseBetween(int startIndex, int endIndex) {

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
        head = dummy.next;
        head.prev = null;
    }

    public void swapInPais() {
        if(head == null) 
            return;

        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;

        Node first = prev.next;

        while(first != null && first.next != null) {
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
