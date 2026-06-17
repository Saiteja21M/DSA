package linkedlist;

import java.util.HashSet;
import java.util.Set;

import linkedlist.LinkedList.Node;

public class LinkedListPrograms {

        public void reverse(LinkedList linkedList) {
        Node temp = linkedList.getHead();
        linkedList.setHead(linkedList.getTail());
        linkedList.setTail(temp);

        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < linkedList.getLength(); i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public Node findKthFromEnd(LinkedList linkedList, int k) {
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

        Node head = linkedList.getHead();
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

    public void removeDuplicates(LinkedList linkedList) {
        Set<Integer> seen = new HashSet<>();

        Node head = linkedList.getHead();
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

    public void partitionList(LinkedList linkedList, int x) {
        Node head = linkedList.getHead();
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

        linkedList.setHead(dummy1.next);
    }

    public void reverseBetween(LinkedList linkedList, int startIndex, int endIndex) {
        Node head = linkedList.getHead();
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

        linkedList.setHead(dummyNode.next);
    }

    public void swapInPairs(LinkedList linkedList) {

        Node head = linkedList.getHead();
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
            second.next = first;

            prev = first;
            first = first.next;
        }

        linkedList.setHead(dummy.next);

    }

    // =====================================================================
    // NEW PRACTICE EXERCISES (stubs only — fill in the logic yourself)
    // =====================================================================

    public boolean hasCycle(LinkedList linkedList) {
        // +===================================================+
        // | EXERCISE: Cycle Detection |
        // | Description: |
        // | - Determine whether this linked list contains a |
        // | cycle, i.e. some node's `next` pointer eventually|
        // | points back to a node earlier in the list. |
        // | |
        // | Example: |
        // | 1 -> 2 -> 3 -> 4 -> (back to 2) => true |
        // | 1 -> 2 -> 3 -> 4 -> null => false |
        // | |
        // | Constraints to aim for: |
        // | - O(n) time, O(1) extra space. |
        // +===================================================+

        Node head = linkedList.getHead();
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    public Node detectCycleStart(LinkedList linkedList) {
        // +===================================================+
        // | EXERCISE: Find Where the Cycle Begins |
        // | Description: |
        // | - If this list contains a cycle, return the node |
        // | where the cycle begins. If there is no cycle, |
        // | return null. |
        // | |
        // | Example: |
        // | 1 -> 2 -> 3 -> 4 -> (back to node 3) |
        // | should return the node with value 3. |
        // | |
        // | Constraints to aim for: |
        // | - O(n) time, O(1) extra space. |
        // +===================================================+

        Node head = linkedList.getHead();
        Node slow = head;
        Node fast = head;

        boolean hasLoop = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }

        if(!hasLoop) return null;

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        

        return slow;
    }

    public Node findMiddle(LinkedList linkedList) {
        // +===================================================+
        // | EXERCISE: Find the Middle Node |
        // | Description: |
        // | - Return the middle node of the list in a single |
        // | pass. |
        // | - Decide for yourself (and document it) what your |
        // | method does for an even-length list: return the |
        // | first middle or the second middle. |
        // | |
        // | Example: |
        // | 1 -> 2 -> 3 -> 4 -> 5 => node with value 3 |
        // | 1 -> 2 -> 3 -> 4 => node with value 2 or 3 |
        // | (your choice, just be consistent) |
        // +===================================================+

        return null; // TODO: implement
    }

    public void removeNthFromEnd(LinkedList linkedList, int n) {
        // +===================================================+
        // | EXERCISE: Remove the N-th Node From the End |
        // | Description: |
        // | - Remove the n-th node from the end of the list, |
        // | updating head/tail/length as needed. |
        // | - Do it in a single pass over the list. |
        // | |
        // | Example: |
        // | 1 -> 2 -> 3 -> 4 -> 5, n = 2 |
        // | => 1 -> 2 -> 3 -> 5 (node 4 removed) |
        // | |
        // | Edge cases to consider: |
        // | - n == length (removing the head) |
        // | - n <= 0 or n > length (invalid input) |
        // +===================================================+

        // TODO: implement
    }

    public static LinkedList mergeSorted(LinkedList a, LinkedList b) {
        // +===================================================+
        // | EXERCISE: Merge Two Sorted Lists |
        // | Description: |
        // | - Given two linked lists that are each already |
        // | sorted in ascending order, merge them into a |
        // | single new sorted linked list and return it. |
        // | - Do not assume both lists are the same length. |
        // | |
        // | Example: |
        // | a: 1 -> 3 -> 5 |
        // | b: 2 -> 4 -> 6 |
        // | result: 1 -> 2 -> 3 -> 4 -> 5 -> 6 |
        // +===================================================+

        return null; // TODO: implement
    }

    public void sortList() {
        // +===================================================+
        // | EXERCISE: Sort the List (Merge Sort) |
        // | Description: |
        // | - Sort this list in ascending order using merge |
        // | sort: split the list in half recursively, sort |
        // | each half, then merge them back together. |
        // | - Do not copy values into an array/ArrayList and |
        // | call a built-in sort — the point is to practice |
        // | sorting the *list* itself. |
        // | |
        // | Target complexity: |
        // | - O(n log n) time. |
        // +===================================================+

        // TODO: implement
    }

    public boolean isPalindrome() {
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
        // | Bonus challenge: |
        // | - Solve it in O(n) time and O(1) extra space |
        // | (hint: you already have a working `reverse()`— |
        // | think about how you could reuse a similar idea |
        // | on just half the list, then restore the list to |
        // | its original shape afterwards). |
        // +===================================================+

        return false; // TODO: implement
    }

    public static LinkedList addTwoNumbers(LinkedList a, LinkedList b) {
        // +===================================================+
        // | EXERCISE: Add Two Numbers |
        // | Description: |
        // | - Each list represents a non-negative integer, |
        // | with digits stored in reverse order (the head is |
        // | the least-significant digit). |
        // | - Add the two numbers and return the sum as a new |
        // | LinkedList, in the same reverse-digit format. |
        // | |
        // | Example: |
        // | a: 2 -> 4 -> 3 (represents 342) |
        // | b: 5 -> 6 -> 4 (represents 465) |
        // | result: 7 -> 0 -> 8 (represents 807) |
        // | |
        // | Don't forget to handle the final carry, and lists |
        // | of different lengths. |
        // +===================================================+

        return null; // TODO: implement
    }

    public void rotateRight(LinkedList linkedList, int k) {
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
        // +===================================================+

        // TODO: implement
    }

    public static Node getIntersectionNode(LinkedList a, LinkedList b) {
        // +===================================================+
        // | EXERCISE: Intersection of Two Linked Lists |
        // | Description: |
        // | - Given the heads of two singly linked lists, |
        // | return the node at which they intersect (the |
        // | exact same Node instance, not just equal value), |
        // | or null if the two lists never intersect. |
        // | - Must not modify either input list. |
        // | |
        // | Target complexity: |
        // | - O(n + m) time, O(1) extra space. |
        // | (i.e. don't just throw every node into a HashSet— |
        // | try it that way first if it helps, then think |
        // | about how to do it without extra space) |
        // +===================================================+

        return null; // TODO: implement
    }

}
