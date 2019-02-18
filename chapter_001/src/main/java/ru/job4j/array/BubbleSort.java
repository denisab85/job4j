package ru.job4j.array;

import java.util.Arrays;

/**
 * Bubble sort of integer arrays.
 *
 * @author Denis Abakumov
 * @version $Id$
 */
public class BubbleSort {

    /**
     * Sorts an array using the bubble sort algorithm.
     * Note: the input array will be sorted within itself and then returned.
     *
     * @param array array to sort
     * @return sorted array.
     */
    public int[] sort(int[] array) {
        int end = array.length;
        while (--end > 0) {
            System.out.println(end);
            for (int i = 1; i <= end; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
        }
        return array;
    }
}
