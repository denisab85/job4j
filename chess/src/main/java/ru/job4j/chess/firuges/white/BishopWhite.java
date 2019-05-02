package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite implements Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * Bishop can move any number of vacant squares in any diagonal direction.
     *
     * @param source initial square
     * @param dest   desired square
     * @return true if move is possible, false otherwise
     */
    @Override
    public boolean isMovePossible(Cell source, Cell dest) {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        return Math.abs(deltaX) == Math.abs(deltaY);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!isMovePossible(source, dest)) {
            throw new ImpossibleMoveException(String.format("Move is impossible for %s: %s -> %s", this.getClass().getSimpleName(), source, dest));
        }
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        int length = Math.max(Math.abs(deltaX), Math.abs(deltaY));
        Cell[] steps = new Cell[length];
        int incX = (int) Math.signum(deltaX);
        int incY = (int) Math.signum(deltaY);
        for (int i = 0; i < length; i++) {
            steps[i] = Cell.inPosition(source.x + incX * (i + 1), source.y + incY * (i + 1));
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
