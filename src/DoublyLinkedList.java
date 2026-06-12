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

}
