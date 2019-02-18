package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Abakumov
 * @version $Id$
 */
public class MatrixCheckTest {

    @Test
    public void whenOddSizeMonoThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] matrix = {
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(matrix);
        assertThat(result, is(true));
    }

    @Test
    public void whenOddSizeNotMonoThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] matrix = {
                {true, false, true},
                {false, false, false},
                {true, false, true}
        };
        boolean result = check.mono(matrix);
        assertThat(result, is(false));
    }


    @Test
    public void whenEvenSizeMonoThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] matrix = {
                {true, false},
                {false, true}
        };
        boolean result = check.mono(matrix);
        assertThat(result, is(true));
    }

    @Test
    public void whenEvenSizeNotMonoThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] matrix = {
                {true, false},
                {true, true}
        };
        boolean result = check.mono(matrix);
        assertThat(result, is(false));
    }

}
