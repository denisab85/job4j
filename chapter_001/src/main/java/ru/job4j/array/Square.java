package ru.job4j.array;

/**
 * Numeric array operations.
 *
 * @author Denis Abakumov
 * @version $Id$
 */
public class Square {

    /**
     * Calculates the square of sequential positive numbers in a range starting with 1, inclusive.
     *
     * @param bound the upper limit for the range, inclusive.
     * @return array of squares.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++) {
            rst[i - 1] = i * i;
        }
        return rst;
    }
}
