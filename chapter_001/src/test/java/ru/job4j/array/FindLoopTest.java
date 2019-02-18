package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Abakumov
 * @version $Id$
 */
public class FindLoopTest {

    @Test
    public void whenFindFirstElement() {
        int[] data = {5, 2, 6, 8, 7};
        FindLoop find = new FindLoop();
        int expected = 0;
        int actual = find.indexOf(data, 5);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenFindLastElement() {
        int[] data = {5, 2, 6, 8, 7};
        FindLoop find = new FindLoop();
        int expected = 4;
        int actual = find.indexOf(data, 7);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenFindNonExistingElementThenMinusOne() {
        int[] data = {5, 2, 6, 8, 7};
        FindLoop find = new FindLoop();
        int expected = -1;
        int actual = find.indexOf(data, 1);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenFindTheOnlyElement() {
        int[] data = {10};
        FindLoop find = new FindLoop();
        int expected = 0;
        int actual = find.indexOf(data, 10);
        assertThat(actual, is(expected));
    }
}
