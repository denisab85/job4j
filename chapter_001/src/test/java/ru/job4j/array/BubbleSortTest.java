package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Abakumov
 * @version $Id$
 */
public class BubbleSortTest {

    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        int[] array = {5, 2, 1, 3, 9, 0, 4, 6, 8, 7};
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        BubbleSort sorter = new BubbleSort();
        int[] actual = sorter.sort(array);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenSortArrayWithSomeEqualElementsThenSortedArray() {
        int[] array = {5, 2, 1, 3, 0, 0, 4, 6, 8, 8};
        int[] expected = {0, 0, 1, 2, 3, 4, 5, 6, 8, 8};
        BubbleSort sorter = new BubbleSort();
        int[] actual = sorter.sort(array);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenSortArrayWithZeroElementsThenNoChange() {
        int[] array = {};
        int[] expected = {};
        BubbleSort sorter = new BubbleSort();
        int[] actual = sorter.sort(array);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenSortArrayWithOneElementThenNoChange() {
        int[] array = {5};
        int[] expected = {5};
        BubbleSort sorter = new BubbleSort();
        int[] actual = sorter.sort(array);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenSortArrayWithTwoUnequalElementsThenSortedArray() {
        int[] array = {5, 1};
        int[] expected = {1, 5};
        BubbleSort sorter = new BubbleSort();
        int[] actual = sorter.sort(array);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenSortArrayWithAllEqualElementsThenNoChange() {
        int[] array = {1, 1, 1};
        int[] expected = {1, 1, 1};
        BubbleSort sorter = new BubbleSort();
        int[] actual = sorter.sort(array);
        assertThat(actual, is(expected));
    }
}
