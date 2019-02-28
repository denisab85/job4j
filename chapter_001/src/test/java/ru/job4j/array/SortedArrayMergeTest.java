package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Denis Abakumov
 * @version $Id$
 * @since 0.1
 */
public class SortedArrayMergeTest {

    @Test
    public void whenArraysOfSameSizeThenMergedArray() {
        int[] array1 = {1, 2, 5, 8, 10};
        int[] array2 = {1, 3, 4, 5, 7};

        SortedArrayMerge merger = new SortedArrayMerge();
        int[] merged = merger.merge(array1, array2);
        int[] expected = {1, 1, 2, 3, 4, 5, 5, 7, 8, 10};
        assertThat(merged, is(expected));
    }

    @Test
    public void whenFirstArrayIsSmallerThenMergedArray() {
        int[] array1 = {1, 2, 5, 8, 10};
        int[] array2 = {1, 3, 4, 5, 7, 15};

        SortedArrayMerge merger = new SortedArrayMerge();
        int[] merged = merger.merge(array1, array2);
        int[] expected = {1, 1, 2, 3, 4, 5, 5, 7, 8, 10, 15};
        assertThat(merged, is(expected));
    }

    @Test
    public void whenFirstArrayIsBiggerThenMergedArray() {
        int[] array1 = {-1, 2};
        int[] array2 = {1};

        SortedArrayMerge merger = new SortedArrayMerge();
        int[] merged = merger.merge(array1, array2);
        int[] expected = {-1, 1, 2};
        assertThat(merged, is(expected));
    }

    @Test
    public void whenMergeTwoArraysWithAllNumbersEqual() {
        int[] array1 = {1, 1, 1};
        int[] array2 = {1, 1, 1, 1, 1};

        SortedArrayMerge merger = new SortedArrayMerge();
        int[] merged = merger.merge(array1, array2);
        int[] expected = {1, 1, 1, 1, 1, 1, 1, 1};
        assertThat(merged, is(expected));
    }

    @Test
    public void whenMergeTwoArraysOfSize1() {
        int[] array1 = {1};
        int[] array2 = {1};

        SortedArrayMerge merger = new SortedArrayMerge();
        int[] merged = merger.merge(array1, array2);
        int[] expected = {1, 1};
        assertThat(merged, is(expected));
    }

    @Test
    public void whenMergeTwoEmptyArraysThenEmptyArray() {
        int[] array1 = {};
        int[] array2 = {};

        SortedArrayMerge merger = new SortedArrayMerge();
        int[] merged = merger.merge(array1, array2);
        int[] expected = {};
        assertThat(merged, is(expected));
    }
}
