package ru.job4j.max;

/**
 * @author Denis Abakumov
 * @version $Id$
 */
public class Max {

    /**
     * Picks the maximum of 2 integer numbers.
     *
     * @param first  first number.
     * @param second second number.
     * @return the maximum of first and second.
     */
    public int max(int first, int second) {
        return (first > second ? first : second);
    }

    /**
     * Picks the maximum of 3 integer numbers.
     *
     * @param first  first number.
     * @param second second number.
     * @param third  third number.
     * @return the maximum of first and second.
     */
    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }

    /**
     * Picks the maximum of the integer numbers.
     *
     * @param args arbitrary number of integers.
     * @return the maximum of the numbers.
     * @throws ArrayIndexOutOfBoundsException if no args passed.
     */
    public int max(int... args) {
        int max = args[0];
        for (int x : args) {
            max = max(max, x);
        }
        return max;
    }
}
