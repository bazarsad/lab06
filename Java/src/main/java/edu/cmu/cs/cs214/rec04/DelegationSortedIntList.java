package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (getTotalAdded) for this count.
 *
 * Uses COMPOSITION (Delegation) by holding a private SortedIntList instance
 * and implementing the IntegerList interface.
 *
 * @author Student
 */
public class DelegationSortedIntList implements IntegerList {

    /** The underlying sorted list we delegate all list operations to. */
    private final SortedIntList sortedList;

    /** Tracks total number of elements attempted to be inserted. */
    private int totalAdded;

    /**
     * Creates an empty DelegationSortedIntList.
     */
    public DelegationSortedIntList() {
        sortedList = new SortedIntList();
        totalAdded = 0;
    }

    /**
     * Adds the specified int to the list and increments totalAdded by 1.
     *
     * @param num an integer to be added to the list
     * @return true if the list is changed as a result of the call
     */
    public boolean add(int num) {
        totalAdded++;
        return sortedList.add(num);
    }

    /**
     * Adds all elements of the given IntegerList and increments totalAdded
     * by the number of elements in the provided list.
     *
     * NOTE: We explicitly count here and delegate to sortedList.addAll().
     * Because sortedList.addAll() calls sortedList.add() (not this.add()),
     * there is NO double-counting risk — our totalAdded is only incremented
     * once here in this method, and the delegation goes straight to the
     * inner SortedIntList without touching our counter again.
     *
     * @param list IntegerList containing elements to be added
     * @return true if the list changed as a result of the call
     */
    public boolean addAll(IntegerList list) {
        totalAdded += list.size();
        return sortedList.addAll(list);
    }

    /**
     * Returns the integer at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    public int get(int index) {
        return sortedList.get(index);
    }

    /**
     * Removes the first occurrence of the specified element from the list.
     *
     * @param num an integer to be removed from the list, if present
     * @return true if an element was removed as a result of this call
     */
    public boolean remove(int num) {
        return sortedList.remove(num);
    }

    /**
     * Removes from the list all elements contained in the specified list.
     *
     * @param list IntegerList containing elements to be removed
     * @return true if the list changed as a result of the call
     */
    public boolean removeAll(IntegerList list) {
        return sortedList.removeAll(list);
    }

    /**
     * Returns the number of elements currently in this list.
     *
     * @return number of elements in the list
     */
    public int size() {
        return sortedList.size();
    }

    /**
     * Returns the total number of elements that have been added
     * (attempted to be inserted) to the list since creation.
     *
     * @return total number of insertion attempts
     */
    public int getTotalAdded() {
        return totalAdded;
    }
}