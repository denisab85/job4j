package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Abakumov
 * @version $Id$
 */
public class PaintTest {

    @Test
    public void whenDrawPyramidHeight1() {
        Paint paint = new Paint();
        String expected = "^";
        String actual = paint.pyramid(1);
        System.out.println(actual);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenDrawPyramidHeight3() {
        Paint paint = new Paint();
        String expected = String.format("  ^  %1$s ^^^ %1$s^^^^^", System.lineSeparator());
        String actual = paint.pyramid(3);
        System.out.println(actual);
        assertThat(actual, is(expected));
    }

}
