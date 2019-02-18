package ru.job4j.array;

/**
 * Checks that an array consists of all 'true' or all 'false' values.
 *
 * @author Denis Abakumov
 * @version $Id$
 */
public class Check {

    /**
     * Checks that an array consists of all 'true' or all 'false' values.
     *
     * @param data array to check.
     * @return true if all elements are true or if all elements are false. False if both false and true are found.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = data.length - 1; i > 0; i--) {
            if (data[i] != data[i - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
