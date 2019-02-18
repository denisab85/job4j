package ru.job4j.array;

/**
 * Character array wrapper.
 *
 * @author Denis Abakumov
 * @version $Id$
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Tests if this string starts with the specified prefix.
     *
     * @param prefix prefix.
     * @return true if the argument is a prefix of this {@code ArrayChar} object.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        if (value.length > data.length) {
            result = false;
        } else {
            int i = value.length;
            while (--i >= 0) {
                if (data[i] != value[i]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
