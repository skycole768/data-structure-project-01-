
/**
 * Class that creates SortedLinkedList objects, which are lists mode up of nodes that point to other
 * nodes, and is sorted by value.
 */
public class SortedLinkedList {

    private NodeType head; // begining of sortedLinkedList
    private NodeType currentPos; // current posistion of list iterator
    private boolean next = false; // true if getNextItem has been called without the list resetting

    /**
     * Constructor that initializes the head and currentPos values;
     */
    public SortedLinkedList() {
        head = null;
        currentPos = head;
    }

    /**
     *  Function that returns the length of the current SortedlinkedList object
     */
    public int getLength() {
        NodeType tempNode = head;
        int length = 0;

        while (tempNode != null) {
            length++;
            tempNode = tempNode.next;
        }

        return length;
    }

    /**
     *  Function that adds the ItemType specfied by item to the current SortedlinkedList object.
     */
    public void insertItem(ItemType item) {

        int length = getLength();

        NodeType newNode = new NodeType(); // new node that will hold item
        NodeType lastNode = getNode(length - 1); //last node of the current list
        newNode.info = item;

        if (length == 0) { // inserting into empty list
            head = newNode;
        } else if (lastNode.info.compareTo(item) == -1) { //inserting at end of list
            lastNode.next = newNode;

        } else if (getNode(0).info.compareTo(item) == 1) { //inserting at beginning of list
            newNode.next = getNode(0);
            if (currentPos == head) {
                currentPos = newNode;
            }
            head = newNode;

        }
        else { // inserting into middle
            for (int i = 0; i < length; i++) {

                if (getNode(i).info.compareTo(item) == 1) {
                    newNode.next = getNode(i);
                    getNode(i - 1).next = newNode;

                    return;
                }

                if (getNode(i).info.compareTo(item) == 0) { // duplicate item

                    System.out.println("Sorry. You cannot insert the duplicate item");
                    return;
                }
            }

        }
    }

    /**
     * Functionn that returns node at location specified by int position in the current linkedlist.
     */
    public NodeType getNode(int position) {
        NodeType tempNode = head;

        if (getLength() > 0 && position < getLength()) {

            for (int i = 0; i < position; i++) {
                tempNode = tempNode.next;
            }
        }
        return tempNode;
    }

    /**
     * Function that deletes the ItemType specfied by item from the current SortedlinkedList object.
     */
    public void deleteItem(ItemType item) {

        int length = getLength();

        if (length == 0) { // deleting from an empty list

            System.out.println("You cannot delete from an empty list");
            return;
        }

        int location = searchItem(item);

        if (location == -1) { // item not present in list
            System.out.println("Item not found");
            return;
        }
        else if (length == 1) { // deleting only item
            head = null;
            currentPos = null;
        } else if (location == 0) { //deleting beginning of list;

            if (currentPos == head) {
                currentPos = head.next;
            }
            head = head.next;

        } else if (location == length - 1) { ////deleting end of list;
            getNode(location - 1).next = null;
        } else { //deleting middle of list
            getNode(location - 1).next = getNode(location + 1);
        }
    }

    /**
     * Function that searches for the ItemType, specfied by item, in the current SortedlinkedList
     * object and returns the index of said item or -1, if not found.
     */
    public int searchItem(ItemType item) {
        int length = getLength();
        boolean found = false;
        int location = -1;

        for (int i = 0; i < length && !found; i++) {
            location++;
            if (getNode(i).info.compareTo(item) == 0) {
                found = true;
            }
        }

        if (!found) {
            location = -1;
            System.out.println("Item not found");
        }
        return location;
    }

    /**
     * Function that returns the next ItemType object of the current position.
     */
    public ItemType getNextItem() {

        int length = getLength();

        if (length == 0) {
            System.out.println("List is empty");
            return null;
        }


        ItemType nextItem;

        if (currentPos == null && next == false) { // if getNextItem hasn't been called yet
            currentPos = head; // initializing currentPos to head
            nextItem = currentPos.info;
            next = true;
        } else {
            currentPos = currentPos.next;

            nextItem = currentPos.info;
        }

        if (currentPos == null & head != currentPos) {
            System.out.println("The end of the list has been reached");
        }


        return nextItem;
    }


    /**
     * Function that resets currentPos, an iterator, to the beginning.
     */
    public void resetList() {
        currentPos = null;
        next = false;
    }


    /**
     * Function that returns a SortedLinkedList object that is the
     * merge of the current SortedLinkedList object with another SortedLinkedList
     * object as specified by list.
     */
    public SortedLinkedList mergeList(SortedLinkedList list) {

        SortedLinkedList copy = new SortedLinkedList(); // copy of list

        for (int i = 0; i < list.getLength(); i++) { //copying
            copy.insertItem(list.getNode(i).info);
        }

        SortedLinkedList merge = new SortedLinkedList();

        for (int i = 0; i < getLength(); i++) {
            for (int j = 0; j < copy.getLength(); j++) {

                if (getNode(i).info.compareTo(copy.getNode(j).info) == 0) {
                    copy.deleteItem(copy.getNode(j).info); // delete duplicates from copy
                }
            }
        }

        for (int i = 0; i < copy.getLength(); i++) {
            merge.insertItem(copy.getNode(i).info);
        }

        for (int i = 0; i < getLength(); i++) {
            merge.insertItem(getNode(i).info);
        }


        return merge;
    }

    /**
     * Fuction that deletes alternates nodes from the current list,
     * so all nodes at odd indexes(index >= 0) being deleted.
     */
    public void deleteAlternates() {
        int length = getLength();

        for (int i = 1; i < length/2 + 1; i++) {
            deleteItem(getNode((2*i) - 1 - (i-1)).info); // deletes items at odd positions
        }


    }

    /**
     * Fuction that finds duplicate node values from the current list,
     * as compared to the SortedLinkedList specified by list,
     * and prints them.
     */
    public void findIntersection(SortedLinkedList list) {

        for (int i = 0; i < getLength(); i++) {
            for (int j = 0; j < list.getLength(); j++) {

                if (getNode(i).info.compareTo(list.getNode(j).info) == 0) {
                    System.out.print(list.getNode(j).info.getValue());
                    System.out.print(" ");
                }
            }
        }

    }

}
