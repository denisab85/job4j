package ru.job4j.array;

/**
 * Revert the order of elements in an array.
 *
 * @author Denis Abakumov
 * @version $Id$
 */
public class Turn {

    /**
     * Reverts the order of elements in an array.
     *
     * @param array array to revert.
     * @return reverted array.
     */
    public int[] back(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            int swapElementIndex = array.length - 1 - i;
            array[i] = array[swapElementIndex];
            array[swapElementIndex] = temp;
        }
        return array;
    }

}
