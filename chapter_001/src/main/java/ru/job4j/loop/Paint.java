package ru.job4j.loop;

import java.util.StringJoiner;
import java.util.function.BiPredicate;

/**
 * Paints different geometric shapes
 *
 * @author Denis Abakumov
 * @version $Id$
 */
public class Paint {

    /**
     * Paints a left-sided rectangular triangle with the defined height.
     *
     * @param height vertical dimension.
     * @return string representing a triangle.
     */
    public String triangleLeft(int height) {
        return this.loopBy(height, height, (x, y) -> y >= height - x - 1);
    }

    /**
     * Paints a right-sided rectangular triangle with the defined height.
     *
     * @param height vertical dimension.
     * @return string representing a triangle.
     */
    public String triangleRight(int height) {
        return this.loopBy(height, height, (x, y) -> x <= y);
    }

    /**
     * Paints a pyramid with the defined height.
     *
     * @param height vertical dimension.
     * @return string representing a pyramid.
     */
    public String pyramid(int height) {
        return this.loopBy(height * 2 - 1, height, (x, y) -> y >= height - x - 1 && x <= y + height - 1);
    }

    private String loopBy(int width, int height, BiPredicate<Integer, Integer> predicate) {
        StringJoiner board = new StringJoiner(System.lineSeparator());
        for (int y = 0; y < height; y++) {
            StringBuilder row = new StringBuilder();
            for (int x = 0; x < width; x++) {
                row.append(predicate.test(x, y) ? "^" : " ");
            }
            board.add(row.toString());
        }
        return board.toString();
    }

}
