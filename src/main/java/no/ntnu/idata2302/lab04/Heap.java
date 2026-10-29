package no.ntnu.idata2302.lab04;

import java.util.ArrayList;

public class Heap {

    /**
     * Creates a {@link Heap} with the given {@code values}.
     *
     * @param values is a freely chosen number of int values to be stored into the {@link Heap}.
     *               Multiple int values are passed as numbers separated by commas.
     *               <p>
     *                 Example:
     *               </p>
     *               <p>
     *                 {@code fromValues(2, 5, 12);}
     *               </p>
     *               <p>
     *                 {@code fromValues(3, 9, 10, 15, 21);}
     *               </p>
     * @return a {@link Heap} containing the given {@code values}.
     */
    public static Heap fromValues(int... values) {
        var heap = new Heap();
        for (var each : values) {
            heap.insert(each);
        }
        return heap;
    }

    private ArrayList<Integer> array;

    /**
     * Checks if the heap is empty.
     * The heap is defined as empty if it only holds the placeholder value {@code 0},
     * and nothing else.
     *
     * @return {@code true} if the size of {@link #array} is {@code 1},
     *              and its only element is the value {@code 0}.
     *              {@code false} if not.
     */
    public boolean isEmpty()    {
        return (array.size() <= 1 && array.get(0) == 0);
    }

    /**
     * Creates a new {@link Heap} object with an {@link ArrayList}.
     *
     * <p>
     *   The value {@code 0} is added in the first spot as a placeholder
     *   to make the rest of the list logic use 1-indexing.
     * </p>
     */
    public Heap() {
        array = new ArrayList<Integer>();
        array.add(0);
    }

    /**
     * Inserts the value {@code k} in the heap,
     * and bubbles it upwards into its correct priority spot.
     *
     * @param k is the value to insert.
     * @throws IllegalArgumentException if {@code k} is {@code null},
     *              or if {@code k} is less than {@code 1}.
     */
    public void insert(Integer k) {
        if (k == null)  {
            throw new IllegalArgumentException("Cannot insert null in the heap.");
        }
        if (k < 1)  {
            throw new IllegalArgumentException("Only values above 0 are approved.");
        }

        array.add(k);
        bubbleUp(array.size() - 1);
    }

    /**
     * Removes the lowest value from the heap, and returns it.
     *
     * @return the lowest value of the heap.
     */
    public int takeMinimum() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Heap is empty. No lowest value found.");
        }

        int lowest = array.get(1);

        swap(1, array.size() - 1);
        array.remove(array.size() - 1);

        bubbleDown(1);

        return lowest;
    }

    public void decreaseKey(int i, int k) {
        // TODO: Implement this operation
        throw new RuntimeException("Not yet implemented");
    }

    /**
     * Bubbles a value down into its correct priority position.
     *
     * @param index is the index of the value to bubble down.
     * @throws IndexOutOfBoundsException if the given {@code index} is less than {@code 1},
     *              or higher than max index {@code array.size() - 1}.
     */
    private void bubbleDown(int index)  {
        if (index < 1 || index >= array.size()) {
            throw new IndexOutOfBoundsException(
                "Index less than 1 or higher than max array index."
            );
        }

        int indexValue = array.get(index);

        int leftChildValue = 0;
        int rightChildValue = 0;

        int leftChildIndex = leftChildOf(index);
        int rightChildIndex = rightChildOf(index);

        try {
            leftChildValue = array.get(leftChildIndex);
        } catch (IndexOutOfBoundsException e)   {
            // Expected if no child. Do nothing and continue.
        }
        try {
            rightChildValue = array.get(rightChildIndex);
        } catch (IndexOutOfBoundsException e)   {
            // Expected if no child. Do nothing and continue.
        }

        if ((leftChildValue == 0 && rightChildValue == 0) ||
            (indexValue <= leftChildValue && indexValue <= rightChildValue) ||
            (indexValue <= leftChildValue && rightChildValue == 0) ||
            (leftChildValue == 0 && indexValue <= rightChildValue))    {
            // Our value has reached its correct position.
            return;
        }
        if (leftChildValue < rightChildValue)   {
            swap(index, leftChildIndex);
            bubbleDown(leftChildIndex);
        }   else    {
            swap(index, rightChildIndex);
            bubbleDown(rightChildIndex);
        }
    }

    /**
     * Bubbles the value at the given {@code index} upwards
     * as long as it's a lower value than its current parent,
     * or the parent is a placeholder value {@code 0}.
     *
     * @param index is the index of the value to potentially bubble upwards.
     * @throws IndexOutOfBoundsException if the given {@code index} is less than {@code 1},
     *              or higher than max index {@code array.size() - 1}.
     */
    private void bubbleUp(int index)    {
        if (index < 1 || index >= array.size()) {
            throw new IndexOutOfBoundsException(
                "Index less than 1 or higher than max array index."
            );
        }

        // If the index is the top node in the tree -> Don't bubble further.
        if (index == 1) {
            return;
        }

        int parentIndex = parentOf(index);

        Integer k = array.get(index);
        Integer parent = array.get(parentIndex);

        if (k < parent || parent == 0)  {
            swap(index, parentIndex);
            bubbleUp(parentIndex);
        }
    }

    /**
     * Returns the parent of the given {@code index}.
     *
     * @param index is the index of the value to find the parent of.
     * @return the parent of the value in the given {@code index}.
     */
    private int parentOf(int index) {
        return index / 2;
    }

    /**
     * Returns the left child value of the value in the given {@code index}.
     *
     * @param index is the index of the value to find the left child of.
     * @return the left child of the value in the given {@code index}.
     */
    private int leftChildOf(int index) {
        return index * 2;
    }

    /**
     * Returns the right child value of the value in the given {@code index}.
     *
     * @param index is the index of the value to find the right child of.
     * @return the right child of the value in the given {@code index}.
     */
    private int rightChildOf(int index) {
        return index * 2 + 1;
    }

    /**
     * Swaps the indexes, and thus {@link #array} placements, of two values.
     *
     * @param pos1 the index of a value to swap position.
     * @param pos2 the index of a value to swap position.
     */
    void swap(int pos1, int pos2) {
        int temp = array.get(pos1);
        array.set(pos1, array.get(pos2));
        array.set(pos2, temp);
    }
}
