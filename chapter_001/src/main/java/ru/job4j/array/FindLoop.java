package ru.job4j.array;

/**
 * Find element in an array.
 *
 * @author Denis Abakumov
 * @version $Id$
 */
public class FindLoop {

    /**
     * Finds element in an array.
     *
     * @param data    array of int.
     * @param element element to find.
     * @return index of element, if not found returns -1.
     */
    public int indexOf(int[] data, int element) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == element) {
                return i;
            }
        }
        return -1;
    }
}
