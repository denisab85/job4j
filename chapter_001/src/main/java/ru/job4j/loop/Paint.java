package ru.job4j.loop;

import java.util.StringJoiner;

/**
 * Paints different geometric shapes
 *
 * @author Denis Abakumov
 * @version $Id$
 */
public class Paint {
    /**
     * Paints a pyramid with the defined height.
     *
     * @param height vertical dimension.
     * @return string representing a pyramid.
     */
    public String pyramid(int height) {
        StringJoiner board = new StringJoiner(System.lineSeparator());
        for (int y = height - 1; y >= 0; y--) {
            StringBuilder row = new StringBuilder();
            for (int x = 0; x < height * 2 - 1; x++) {
                boolean print = (x >= y) && (x <= height * 2 - 2 - y);
                row.append(print ? "^" : " ");
            }
            board.add(row.toString());
        }
        return board.toString();
    }
}
