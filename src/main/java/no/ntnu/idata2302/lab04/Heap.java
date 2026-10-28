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
        return (array.size() == 1 && array.get(0) == 0);
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

    public void insert(Integer k) {
        if (k == null)  {
            throw new IllegalArgumentException("Cannot insert null in the heap.");
        }


    }

    public int takeMinimum() {
        // TODO: Implement this operation
        throw new RuntimeException("Not yet implemented");
    }

    public void decreaseKey(int i, int k) {
        // TODO: Implement this operation
        throw new RuntimeException("Not yet implemented");
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
     * Swaps the index positions of two values.
     *
     * @param pos1 one value whom's index position will be swapped.
     * @param pos2 one value whom's index position will be swapped.
     */
    void swap(int pos1, int pos2) {
        int temp = array.get(pos1);
        array.set(pos1, array.get(pos2));
        array.set(pos2, temp);
    }
}
