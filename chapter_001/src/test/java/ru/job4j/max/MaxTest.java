package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Abakumov
 * @version $Id$
 */
public class MaxTest {

    @Test
    public void whenFirstLessThanSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenFirstGreaterThanSecond() {
        Max maxim = new Max();
        int result = maxim.max(20, 11);
        assertThat(result, is(20));
    }

    @Test
    public void whenFirstEqualsSecond() {
        Max maxim = new Max();
        int result = maxim.max(5, 5);
        assertThat(result, is(5));
    }

    @Test
    public void whenThreeArgumentsPassed() {
        Max maxim = new Max();
        int result = maxim.max(5, 6, 5);
        assertThat(result, is(6));
    }

    @Test
    public void whenArbitraryNumberOfArgumentsPassed() {
        Max maxim = new Max();
        int result = maxim.max(1, -6, 25, 48, -50);
        assertThat(result, is(48));
    }

}