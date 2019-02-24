package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Abakumov
 * @version $Id$
 */
public class ArrayDuplicateTest {

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] array = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expected = {"Привет", "Мир", "Супер"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] actual = duplicate.remove(array);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenNoDuplicatesThenArrayUnchanged() {
        String[] array = {"Привет", "Супер", "Мир"};
        String[] expected = {"Привет", "Супер", "Мир"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] actual = duplicate.remove(array);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenAllDuplicatesThenOneStringArray() {
        String[] array = {"Привет", "Привет"};
        String[] expected = {"Привет"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] actual = duplicate.remove(array);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenOneElementThenNoChange() {
        String[] array = {"Привет"};
        String[] expected = {"Привет"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] actual = duplicate.remove(array);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenNoElementsThenNoChange() {
        String[] array = {};
        String[] expected = {};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] actual = duplicate.remove(array);
        assertThat(actual, is(expected));
    }
}
