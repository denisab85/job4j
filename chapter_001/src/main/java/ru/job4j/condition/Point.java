package ru.job4j.condition;

/**
 * Represents a point in a 2D coordinate system.
 *
 * @author Denis Abakumov
 */
public class Point {

    private int x;
    private int y;

    /**
     * Creates a point with preset coordinates.
     *
     * @param x horizontal coordinate
     * @param y vertical coordinate
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates distance to another Point.
     *
     * @param that the other point.
     * @return distance to the other point.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }
}
