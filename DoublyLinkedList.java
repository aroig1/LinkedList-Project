public class DoublyLinkedList {

    // Inner node class for the doubly linked list
    private class Node {
        int  data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = this.head;
    }

    // Method to insert a node
    public void insert(int data) {
        Node newNode = new Node(data);
        
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Method to delete the head
    public void deleteHead() {
        if (!this.isEmpty()) {
            head = head.next;
            head.prev = null;
        }
    }

    // Method to delete the tail
    public void deleteTail() {
        if (!this.isEmpty()) {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Method to delete a node with the given value
    public void delete(int data) {
        Node tempNode = head;

        if (!this.isEmpty()) {
            if (head.data == data) {
                head = head.next;
                head.prev = null;
                return;
            }
            while (tempNode.next != null) {
                tempNode = tempNode.next;
                if (tempNode.data == data) {
                    tempNode.prev.next = tempNode.next;
                    tempNode.next.prev = tempNode.prev;
                    return;
                }
            }

            System.out.println("\nDelete Failed. Element with value " + data + " was not found.");
        }
    }

    // Method to search for a certain element
    public int search(int data) {
        Node tempNode = head;
        int count = 0;

        if (!this.isEmpty()) {
            if (head.data == data) {
                return count;
            }
            while (tempNode.next != null) {
                tempNode = tempNode.next;
                ++count;
                if (tempNode.data == data) {
                    return count;
                }
            }
        }
        return -1;
    }

    // Method for forward traversal
    public void forwardTraversal() {
        Node tempNode = this.head;

        if (!isEmpty()) {
            System.out.print("Forward: " + tempNode.data);
            while (tempNode.next != null) {
                tempNode = tempNode.next;
                System.out.print(" -> " + tempNode.data);
            }
            System.out.println();
        }
    }

    // Method for backward traversal
    public void backwardTraversal() {
        Node tempNode = this.tail;

        if (!isEmpty()) {
            System.out.print("Backward: " + tempNode.data);
            while (tempNode.prev != null) {
                tempNode = tempNode.prev;
                System.out.print(" -> " + tempNode.data);
            }
            System.out.println();
        }
    }

    public boolean isEmpty() {
        if (head == null) {
            System.out.println("This Doubly Linked List is Empty");
            return true;
        }
        return false;
    }
}
