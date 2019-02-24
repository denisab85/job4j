package ru.job4j.array;

import java.util.Arrays;

/**
 * Removes duplicate elements from a String array.
 *
 * @author Denis Abakumov
 * @version $Id$
 */
public class ArrayDuplicate {

    /**
     * Removes duplicate elements from a String array.
     * Note: will also sort elements in the input array leaving all duplicates at the end.
     *
     * @param array array to remove duplicates from.
     * @return a new array without duplicate elements.
     */
    public String[] remove(String[] array) {
        int end = array.length;
        int i = 0;
        while (++i < end) {
            for (int c = 0; c < i; c++) {
                if (array[i].equals(array[c])) {
                    String duplicate = array[i];
                    System.arraycopy(array, i + 1, array, i, array.length - i - 1);
                    array[--end] = duplicate;
                }
            }
        }
        return Arrays.copyOf(array, end);
    }
}
