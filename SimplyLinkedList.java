public class SimplyLinkedList {

    // Inner node class for the linked list
    private class Node {
        int  data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public SimplyLinkedList() {
        this.head = null;
    }

    // Method to insert a node
    public void insert(int data) {
        Node newNode = new Node(data);
        Node tempNode = this.head;
        
        if (this.head == null) {
            this.head = newNode;
        }
        else {
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }

            tempNode.next = newNode;
        }
    }

    // Method to delete the head
    public void deleteHead() {
        if (!this.isEmpty()) {
            this.head = this.head.next;
        }
    }

    // Method to delete the tail
    public void deleteTail() {
        Node tempNode = this.head;
        int count = 0;

        if (!this.isEmpty()) {
            while (tempNode.next != null) {
                tempNode = tempNode.next;
                ++count;
            }
            tempNode = this.head;
            for (int i = 0; i < count - 1; ++i) {
                tempNode = tempNode.next;
            }
            tempNode.next = null;
        }
    }

    // Method to delete a node with the given value
    public void delete(int data) {
        Node tempNode = this.head;
        int count = 0;
        boolean dataFound = false;

        if (!this.isEmpty()) {
            if (this.head.data == data && this.head.next != null) {
                this.head = this.head.next;
            }
            else if (this.head.data == data && this.head.next == null) {
                this.head = null;
            }
            else {
                while (tempNode.next != null) {
                    tempNode = tempNode.next;
                    ++count;
                    if (tempNode.data == data) {
                        dataFound = true;
                        break;
                    }
                }
                if (dataFound) {
                    tempNode = this.head;
                    for (int i = 0; i < count - 1; ++i) {
                        tempNode = tempNode.next;
                    }
                    tempNode.next = tempNode.next.next;
                }
                else {
                    System.out.println("\nDelete Failed. Element with value " + data + " was not found.");
                }
            }
        }
    }

    // Method to search for a certain element
    public int search(int data) {
        Node tempNode = this.head;
        int count = 0;

        if (!this.isEmpty()) {
            if (tempNode.data == data) {
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

    // Method for traversal
    public void traverse() {
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

    public boolean isEmpty() {
        if (head == null) {
            System.out.println("This Simply Linked List is Empty");
            return true;
        }
        return false;
    }
}
