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
}
