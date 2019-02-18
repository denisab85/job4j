package ru.job4j.array;

/**
 * Checks that both diagonals in a matrix contain same boolean values.
 *
 * @author Denis Abakumov
 * @version $Id$
 */
public class MatrixCheck {

    /**
     * Checks that both diagonals in a matrix contain same boolean values.
     * Note: if the two diagonals don't have a common cell, they are checked separately.
     *
     * @param data 2d matrix.
     * @return {@code true} if both diagonals in a matrix contain same boolean values, otherwise {@code false}.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;

        int size = data.length;
        for (int i = 1; i < size; i++) {
            if (data[i].length < size) {
                result = false;
                break;
            }
            if (data[i][i] != data[i - 1][i - 1] || data[size - i - 1][i] != data[size - i][i - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }

}
