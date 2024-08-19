import java.io.*;
import java.util.Scanner;

/**
 * Class that prompts user to enter commands that either change or show some state
 * of a SortedLinkedList object as specified by a given file.
 */
public class LinkedListDriver {

    public static void main(String args[]) {


        SortedLinkedList list = new SortedLinkedList();

        try {
            String fileName = args[0];
            File file = new File(fileName);

            Scanner fileReader = new Scanner(file);

            while(fileReader.hasNextInt()) {
                int number = fileReader.nextInt();

                ItemType item = new ItemType(number);
                list.insertItem(item);

            }

            fileReader.close();
        } catch (IOException | ArrayIndexOutOfBoundsException e) { //if file not found or some
                                                                   // other error
            System.out.println("File not found");
            return;
        }


        System.out.printf("Commands:%n(i) - Insert value%n(d) - Delete value%n(s) - Search value");
        System.out.printf("%n(n) - Print next iterator value%n(r) - Reset iterator%n");
        System.out.printf("(a) - Delete alternate nodes%n(m) - Merge lists%n");
        System.out.printf("(t) - Find intersection%n(p) - Print list%n(l) - Print length%n");
        System.out.printf("(q) - Quit program%n");

        Scanner keyboard = new Scanner(System.in);
        boolean quit = false;
        boolean invalid = false;

        while(!quit) {

            if (!invalid) {
                System.out.println("");
                System.out.print("Enter a command: ");
            }

            String input = keyboard.nextLine();



            switch(input) {
            case "i": // insert
                invalid = false;
                insert(list, keyboard);
                break;

            case "d": // delete
                invalid = false;
                delete(list, keyboard);

                break;

            case "s": //search

                invalid = false;
                search(list, keyboard);
                break;

            case "n": //iterate
                invalid = false;
                iterator(list);
                break;
            case "r": // reset iterator
                invalid = false;
                list.resetList();
                System.out.print("Iterator is reset");
                break;
            case "a": // delete alternates
                invalid = false;
                alternates(list);
                break;
            case "m": // merge
                invalid = false;
                merge(list, keyboard);
                break;
            case "t": // find intersection
                invalid = false;
                intersection(list, keyboard);
                break;
            case "p": // print
                invalid = false;
                System.out.print("The list is: ");
                printList(list);
                break;
            case "l": // length
                invalid = false;
                System.out.print("The length of the list is ");
                System.out.print(list.getLength());
                System.out.println("");
                break;
            case "q": // quit
                invalid = false;
                System.out.println("Exiting the program...");
                quit = true;
                break;
            default: // invalid command
                invalid = true;
                System.out.print("Invalid command, try again: ");
                break;
            }

        }

        keyboard.close();
        System.exit(0);
    }


    //prints intersection of two list
    static void intersection(SortedLinkedList list, Scanner keyboard) {
        SortedLinkedList list2 = new SortedLinkedList();

        System.out.print("Enter the length of the new list: ");
        int length = keyboard.nextInt();
        System.out.print("Enter the numbers ");

        for(int i = 0; i < length; i++) {
            int num = keyboard.nextInt();
            ItemType item = new ItemType(num);
            list2.insertItem(item);
        }

        SortedLinkedList list3 = list.mergeList(list2);

        System.out.print("The list 1: ");
        printList(list);
        System.out.println("");

        System.out.print("The list 2: ");
        printList(list2);
        System.out.println("");

        System.out.print("Intersection of lists: ");
        list.findIntersection(list2);
        System.out.println("");

        keyboard.nextLine();

    }

    // prints merge of two lists
    static void merge(SortedLinkedList list, Scanner keyboard) {
        SortedLinkedList list2 = new SortedLinkedList();

        System.out.print("Enter the length of the new list: ");
        int length = keyboard.nextInt();
        System.out.print("Enter the numbers: ");

        for(int i = 0; i < length; i++) {
            int num = keyboard.nextInt();
            ItemType item = new ItemType(num);
            list2.insertItem(item);
        }

        SortedLinkedList list3 = list.mergeList(list2);

        System.out.print("The list 1: ");
        printList(list);
        System.out.println("");

        System.out.print("The list 2: ");
        printList(list2);
        System.out.println("");

        System.out.print("The merged list: ");
        printList(list3);
        System.out.println("");

        keyboard.nextLine();


    }

    //deletes alternates of list
    static void alternates(SortedLinkedList list) {

        System.out.print("Original list: ");
        printList(list);
        System.out.println("");

        if (list.getLength() == 0) {

            System.out.println("The list is empty");

        }
        list.deleteAlternates();
        System.out.print("Modified list: ");
        printList(list);
        System.out.println("");


    }

    //prints next position of list and moves iterator up
    static void iterator(SortedLinkedList list) {

        if (list.getLength() == 0) {
            System.out.println("The list is empty");
            return;
        }
        try{
            ItemType item = list.getNextItem();


            System.out.print(item.getValue());

        } catch (NullPointerException e) {
            System.out.println("End of the list has reached");
        }


    }

    //prints list
    static void printList(SortedLinkedList list) {


        for(int i = 0; i < list.getLength(); i++) {

            System.out.print(list.getNode(i).info.getValue() + " ");
        }
    }

    //searches list for item
    static void search(SortedLinkedList list, Scanner keyboard){

        boolean found = false;

        System.out.print("Enter a number to search: " );

        int num = keyboard.nextInt();
        ItemType item = new ItemType(num);


        System.out.print("Original list : ");
        printList(list);
        System.out.println("");

        for(int i = 0; i < list.getLength(); i++) {
            if (list.getNode(i).info.compareTo(item) == 0) {

                found = true;
            }
        }


        if (list.getLength() == 0) {
            System.out.println("The list is empty");
        } else if (found) {
            int index = list.searchItem(item);
            index++;
            System.out.println("The item is present at index " + index);
        } else {
            System.out.println("Item is not present in the list");
        }

        keyboard.nextLine();

    }

    // deletes item from list
    static void delete(SortedLinkedList list, Scanner keyboard){

        boolean found = false;

        System.out.print("Enter a number to delete: ");
        int num = keyboard.nextInt();
        ItemType item = new ItemType(num);

        if (list.getLength() == 0){
            System.out.println("You cannot delete from an empty list");
            keyboard.nextLine();
            return;
        }

        System.out.print("Original list : ");
        printList(list);
        System.out.println("");

        for(int i = 0; i < list.getLength(); i++) {
            if (list.getNode(i).info.compareTo(item) == 0) {

                found = true;
            }
        }

        if (!found) {
            System.out.println("The item is not present in the list");
        } else {
            list.deleteItem(item);
        }

        System.out.print("New list : ");
        printList(list);
        System.out.println("");

        keyboard.nextLine();

    }

    // adds item to list
    static void insert(SortedLinkedList list, Scanner keyboard) {

        boolean duplicate = false;

        System.out.print("Enter a number to insert: ");


        int num = keyboard.nextInt();
        ItemType item = new ItemType(num);

        System.out.print("Original list : ");
        printList(list);

        System.out.println("");
        for (int i = 0; i < list.getLength(); i++) {

            if (list.getNode(i).info.compareTo(item) == 0) {
                System.out.println("Item already exists");
                duplicate = true;
            }
        }

        if (!duplicate){
            list.insertItem(item);
        }

        System.out.print("New list : ");
        printList(list);
        System.out.println("");

        keyboard.nextLine();

    }
}
