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

    public void append(int value) {
        Node node = new Node(value);
        if(length == 0)
            head = tail = node;
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        length++;
    }

}
