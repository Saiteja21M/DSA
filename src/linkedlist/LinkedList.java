package linkedlist;

import lombok.Data;

@Data
public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    static class Node {
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

    public void printList() {
        Node temp = getHead();
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println();
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

}