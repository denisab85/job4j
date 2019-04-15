package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QueenWhite implements Figure {
    private final Cell position;

    public QueenWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public boolean isMovePossible(Cell source, Cell dest) {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        return deltaX == 0 || deltaY == 0 || Math.abs(deltaX) == Math.abs(deltaY);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        if (isMovePossible(source, dest)) {
            int length = Math.max(Math.abs(deltaX), Math.abs(deltaY));
            steps = new Cell[length];
            int incX = (int) Math.signum(deltaX);
            int incY = (int) Math.signum(deltaY);
            for (int i = 0; i < length; i++) {
                steps[i] = Cell.inPosition(source.x + incX * (i + 1), source.y + incY * (i + 1));
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QueenWhite(dest);
    }
}
