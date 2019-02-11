package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Abakumov
 * @version $Id$
 */
public class CounterTest {

    @Test
    public void whenAddEvenNumbersFrom1To10Then30() {
        Counter counter = new Counter();
        int result = counter.addEven(1, 10);
        assertThat(result, is(30));
    }

    @Test
    public void whenAddEvenNumbersFromMinus1To1Then0() {
        Counter counter = new Counter();
        int result = counter.addEven(-1, 2);
        assertThat(result, is(2));
    }

}
