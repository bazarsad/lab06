package edu.cmu.cs.cs214.rec04;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class InheritanceSortedIntList extends SortedIntList {

    /** Tracks total number of elements attempted to be inserted. */
    private int totalAdded;

    /**
     * Creates an empty InheritanceSortedIntList.
     */
    public InheritanceSortedIntList() {
        super();
        totalAdded = 0;
    }

    /**
     * Adds the specified int to the list and increments totalAdded by 1.
     *
     * @param num an integer to be added to the list
     * @return true if the list is changed as a result of the call
     */
    @Override
    public boolean add(int num) {
        totalAdded++;
        return super.add(num);
    }

    /**
     * Adds all elements of the given IntegerList.
     * super.addAll() calls this.add() for each element,
     * so totalAdded is automatically incremented in add() — no double-counting.
     *
     * @param list IntegerList containing elements to be added
     * @return true if the list changed as a result of the call
     */
    @Override
    public boolean addAll(IntegerList list) {
        return super.addAll(list);
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