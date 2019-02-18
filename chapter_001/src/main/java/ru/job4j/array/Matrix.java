package ru.job4j.array;

/**
 * Draws a multiplication table.
 *
 * @author Denis Abakumov
 * @version $Id$
 */
public class Matrix {

    /**
     * Creates a bidirectional array representing a multiplication table for numbers from 1 to {@param size}.
     *
     * @param size maximum number.
     * @return matrix of (size * size) elements.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
