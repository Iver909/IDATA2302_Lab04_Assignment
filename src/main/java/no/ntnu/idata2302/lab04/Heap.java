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
     * Creates a new {@link Heap} object
     * with an {@link ArrayList}
     * containing the {@link Integer} value {@code 0}.
     */
    public Heap() {
        array = new ArrayList<Integer>();
        array.add(0);
    }

    public void insert(Integer k) {
        // TODO: Implement this operation
        throw new RuntimeException("Not yet implemented");
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
