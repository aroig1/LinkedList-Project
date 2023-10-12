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
        Node prevNode = this.head;
        Node currNode;

        if (!this.isEmpty()) {
            if (prevNode.next == null) {
                prevNode = null;
                return;
            }

            currNode = this.head.next;

            while (currNode.next != null) {
                prevNode = currNode;
                currNode = currNode.next;
            }
            
            prevNode.next = null;
        }
    }

    // Method to delete a node with the given value
    public void delete(int data) {
        Node prevNode = this.head;
        Node currNode;

        if (!this.isEmpty()) {
            if (head.data == data) { // Removing first element
                head = head.next;
                return;
            }

            currNode = prevNode.next;

            if (currNode.data == data) { // Removing second element
                prevNode.next = currNode.next;
                return;
            }

            while (currNode.next != null) { // Removing all other elements
                prevNode = currNode;
                currNode = currNode.next;
                if (currNode.data == data) {
                    prevNode.next = currNode.next;
                    return;
                }
            }

            System.out.println("\nDelete Failed. Element with value " + data + " was not found.");
        }
    }

    // Method to search for a certain element
    public int search(int data) {
        Node tempNode = this.head;
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
