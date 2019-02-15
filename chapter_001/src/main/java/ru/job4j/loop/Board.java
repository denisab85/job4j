package ru.job4j.loop;

import java.util.StringJoiner;

/**
 * Chess board.
 *
 * @author Denis Abakumov
 * @version $Id$
 */
public class Board {

    /**
     * Paints a board with the defined dimensions.
     *
     * @param width  horizontal dimension.
     * @param height vertical dimension.
     * @return string representing a board.
     */
    public String paint(int width, int height) {
        StringJoiner board = new StringJoiner(System.lineSeparator());
        for (int h = 0; h < height; h++) {
            StringBuilder row = new StringBuilder();
            for (int w = 0; w < width; w++) {
                row.append((h + w) % 2 == 0 ? "X" : " ");
            }
            board.add(row.toString());
        }
        return board.toString();
    }
}
