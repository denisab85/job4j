package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Abakumov
 * @version $Id$
 */
public class ArrayCharTest {

    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }

    @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hi");
        assertThat(result, is(false));
    }

    @Test
    public void whenPrefixEmptyThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("");
        assertThat(result, is(true));
    }

    @Test
    public void whenPrefixEqualsTheStringThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hello");
        assertThat(result, is(true));
    }

    @Test
    public void whenStringEmptyAndPrefixIsNotThenFalse() {
        ArrayChar word = new ArrayChar("");
        boolean result = word.startWith("Hi");
        assertThat(result, is(false));
    }

    @Test
    public void whenBothStringAndPrefixEmptyThenTrue() {
        ArrayChar word = new ArrayChar("");
        boolean result = word.startWith("");
        assertThat(result, is(true));
    }
}
