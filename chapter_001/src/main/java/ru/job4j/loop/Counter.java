package ru.job4j.loop;

/**
 * @author Denis Abakumov
 * @version $Id$
 */
public class Counter {

    /**
     * Checks whether the number is even or not.
     *
     * @param number an integer number.
     * @return true if the number is even, false otherwise.
     */
    public boolean isEven(int number) {
        return (number % 2 == 0);
    }

    /**
     * Adds up all even numbers between start and finish (inclusively).
     *
     * @param start  first number.
     * @param finish last number.
     * @return sum of even numbers.
     */
    public int addEven(int start, int finish) {
        int sum = 0;
        for (int num = start; num <= finish; num++) {
            if (isEven(num)) {
                sum += num;
            }
        }
        return sum;
    }
}

