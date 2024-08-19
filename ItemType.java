/**
 * Class for an ItemType object that holds an integer value.
 */
public class ItemType {
    private int value;

    /**
     * Constructor that initializes the itemType varible's value to to the number
     * specified, num.
     */
    public ItemType(int num) {
        value = num;
    }

    /**
     * Has a parameter item, an ItemType object, which's value is compared
     * to the current itemType object's value. If the current is more than
     * item's 1 is return, if equal to then 0 is returned, and if less than
     * -1 is returned.
     *
     */
    public int compareTo(ItemType item) {

        if (value < item.value)
            return -1;
        if (value == item.value)
            return 0;
        else
            return 1;

    }

    /**
     * returns int variable value for an ItemType object
     */
    public int getValue() {
        return value;
    }

}
