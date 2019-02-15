package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Abakumov
 * @version $Id$
 */
public class BoardTest {

    @Test
    public void whenDrawBoard3By3Cells() {
        Board board = new Board();
        String expected = String.format("X X%1$s X %1$sX X", System.lineSeparator());
        String actual = board.paint(3, 3);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenDrawBoard5By4Cells() {
        Board board = new Board();
        String expected = String.format("X X X%1$s X X %1$sX X X%1$s X X ", System.lineSeparator());
        String actual = board.paint(5, 4);
        assertThat(actual, is(expected));
    }
}
