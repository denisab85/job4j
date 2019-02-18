package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Abakumov
 * @version $Id$
 */
public class CheckTest {

    @Test
    public void whenDataMonoOddNumberOfElementsThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataMonoEvenNumberOfElementsThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenOneElementThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}
