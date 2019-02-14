package ru.job4j.loop;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Math factorial calculator.
 *
 * @author Denis Abakumov
 * @version $Id$
 */
public class Factorial {

    /**
     * Calculates the factorial of a number.
     *
     * @param n the number.
     * @return factorial (n!)
     */
    public int calc(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Cannot calculate factorial for negative numbers.");
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
