import java.util.Scanner;

public class LinkedListTest {

    // Class variables for Simple and Double linked lists
    private SimplyLinkedList simpleLinkedList;
    private DoublyLinkedList doublyLinkedList;
    // TODO: Add more class variables if needed

    public LinkedListTest() {
        simpleLinkedList = new SimplyLinkedList();
        doublyLinkedList = new DoublyLinkedList();
    }

    public void insertElements(int[] n) {
        long start, end;
        
        start = System.nanoTime();
        for (int i = 0; i < n.length; ++i) {
            simpleLinkedList.insert(n[i]);
        }
        end = System.nanoTime();
        System.out.println("Simple - Elapsed Time: " + (end - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < n.length; ++i) {
            doublyLinkedList.insert(n[i]);
        }
        end = System.nanoTime();
        System.out.println("Doubly - Elapsed Time: " + (end - start) + " ns");
    }

    public void deleteElement(int option, int data) {
        long start, end;

        switch(option) {
            case 1:
                start = System.nanoTime();
                simpleLinkedList.deleteHead();
                end = System.nanoTime();
                System.out.println("\nSimple - Elapsed Time: " + (end - start) + " ns");

                start = System.nanoTime();
                doublyLinkedList.deleteHead();
                end = System.nanoTime();
                System.out.println("Doubly - Elapsed Time: " + (end - start) + " ns");
                break;
            case 2:
                start = System.nanoTime();
                simpleLinkedList.deleteTail();
                end = System.nanoTime();
                System.out.println("\nSimple - Elapsed Time: " + (end - start) + " ns");

                start = System.nanoTime();
                doublyLinkedList.deleteTail();
                end = System.nanoTime();
                System.out.println("Doubly - Elapsed Time: " + (end - start) + " ns");
                break;
            case 3:
                start = System.nanoTime();
                simpleLinkedList.delete(data);
                end = System.nanoTime();
                System.out.println("\nSimple - Elapsed Time: " + (end - start) + " ns");

                start = System.nanoTime();
                doublyLinkedList.delete(data);
                end = System.nanoTime();
                System.out.println("Doubly - Elapsed Time: " + (end - start) + " ns");
                break;
        }
    }

    public void searchElement(int data) {
        long start, end;

        start = System.nanoTime();
        int index = simpleLinkedList.search(data);
        end = System.nanoTime();
        System.out.println("\nSimple - Elapsed Time: " + (end - start) + " ns");

        start = System.nanoTime();
        int index2 = doublyLinkedList.search(data);
        end = System.nanoTime();
        System.out.println("Doubly - Elapsed Time: " + (end - start) + " ns");

        if (index < 0 && index2 < 0) {
            System.out.println("An element with value " + data + " was not found.");
        }
        else {
            System.out.println("The element with value " + data + " is at the index " + index + " in the simply linked list.");
            System.out.println("The element with value " + data + " is at the index " + index2 + " in the doubly linked list.");
        }
    }

    public void traverseAndPrint() {
        System.out.println();
        long start, end;

        start = System.nanoTime();
        simpleLinkedList.traverse();
        end = System.nanoTime();
        System.out.println("Simple - Elapsed Time: " + (end - start) + " ns");

        start = System.nanoTime();
        doublyLinkedList.forwardTraversal();
        end = System.nanoTime();
        System.out.println("Doubly - Elapsed Time: " + (end - start) + " ns");

        start = System.nanoTime();
        doublyLinkedList.backwardTraversal();
        end = System.nanoTime();
        System.out.println("Doubly - Elapsed Time: " + (end - start) + " ns");
    }

    public void printOptions() {
        System.out.println("\n#####################");
        System.out.println("1) Insert");
        System.out.println("2) Delete");
        System.out.println("3) Search");
        System.out.println("4) Traversal & Print");
        System.out.println("0) Exit");
        System.out.println("#####################");
        System.out.println("Choose one of the above options:");
    }

    public void printOptions2() {
        System.out.println("\nChoose a method to remove an element:");
        System.out.println("1) Head");
        System.out.println("2) Tail");
        System.out.println("3) By Element");
    }

    public static void main(String[] args) {
        // TODO: Implement the command line interface for the user based on the given options
        // When the program starts, print the interface below and wait for the user's input.
        // Make sure the input is in the correct format, otherwise print appropriate message.
        // 
        // #####################
        // 1) Insert
        // 2) Delete
        // 3) Search
        // 4) Traversal & Print
        // 0) Exit
        // #####################
        // 
        // Call appropriate method(s) on both lists and print the execution time
        // for each.
        // 
        // 1) If the user types 1, ask for integers separated by whitespace. (e.g. 1 2 3 4)
        //    Then, insert each integer to both lists.
        // 
        // 2) If the user types 2, show additional options 
        //    1) Head
        //    2) Tail
        //    3) By Element
        //
        // 3) If the user types 3, ask for the element they are looking for.
        //    If it doesn't exist, print appropriate message. 
        //    Otherwise, print the index of the node with appropriate message.
        //
        // 4) If the user types 4, print the both of the lists in the format below
        //    For SimplyLinkedList: Forward:  1 -> 2 -> 3 -> 4
        //    For DoublyLinkedList: Forward:  1 -> 2 -> 3 -> 4
        //                          Backward: 4 -> 3 -> 2 -> 1
        //
        // For each of the options above, print the execution time in nanoseconds for the 
        // operation on each list at the end.
        // 
        // Repeat above until the user types 0.
        //
        // Final note: Searching on the doubly linked list can be noticeably faster using 
        // its tail. Try to utilize this property to efficiently traverse through the list.

        LinkedListTest tester = new LinkedListTest();

        Scanner scnr = new Scanner(System.in);

        tester.printOptions();

        int userChoice = scnr.nextInt();
        int elementChoice;

        while (userChoice < 0 || userChoice > 4) {
            System.out.println("\nYou're choice was invalid");
            tester.printOptions();
            userChoice = scnr.nextInt();
        }
        
        while (userChoice != 0) {
            switch(userChoice) {
                case 1:
                    System.out.println("\nEnter integer values separated by spaces:");
                    String line = scnr.nextLine();
                    line = scnr.nextLine();
                    String[] splitLine = line.split(" ");
                    int[] inputs = new int[splitLine.length];

                    for (int i = 0; i < splitLine.length; ++i) {
                        inputs[i] = Integer.parseInt(splitLine[i]);
                    }

                    tester.insertElements(inputs);
                    break;
                
                case 2:
                    tester.printOptions2();
                    int typeChoice = scnr.nextInt();
                    elementChoice = 0;
                    while (typeChoice < 1 || typeChoice > 3) {
                        System.out.println("\nYou're choice was invalid");
                        tester.printOptions2();
                        typeChoice = scnr.nextInt();
                    }
                    if (typeChoice == 3) {
                        System.out.println("\nInput the element that you would like to delete.");
                        elementChoice = scnr.nextInt();
                    }
                    tester.deleteElement(typeChoice, elementChoice);
                    break;
                
                case 3:
                    System.out.println("\nInput the element that you are looking for.");
                    elementChoice = scnr.nextInt();
                    tester.searchElement(elementChoice);
                    break;
                
                case 4:
                    tester.traverseAndPrint();
                    break;
            }

            tester.printOptions();
            userChoice = scnr.nextInt();

            while (userChoice < 0 || userChoice > 4) {
                System.out.println("\nYou're choice was invalid");
                tester.printOptions();
                userChoice = scnr.nextInt();
            }
        }

        System.out.println("\nENDING TEST\n");
        scnr.close();
    }
}