package ru.job4j.chess;

import ru.job4j.chess.firuges.*;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean rst = false;
        int index = this.findBy(source);

        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                if (wayClear(steps)) {
                    rst = true;
                    this.figures[index] = this.figures[index].copy(dest);
                } else {
                    throw new OccupiedWayException("This way is blocked by other pieces. Please try another move.");
                }
            }
        } else {
            throw new FigureNotFoundException("Piece not found.");
        }
        return rst;
    }

    void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    private boolean wayClear(Cell[] steps) {
        boolean result = true;
        for (Cell cell : steps) {
            if (occupiedBy(cell) != null) {
                result = false;
                break;
            }
        }
        return result;
    }

    private Figure occupiedBy(Cell cell) {
        Figure result = null;
        for (Figure figure : figures) {
            if (figure != null && figure.position().equals(cell)) {
                result = figure;
                break;
            }
        }
        return result;
    }
}
