package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Abakumov
 * @version $Id$
 */
public class TurnTest {

    @Test
    public void whenTurnArrayWithEvenNumberOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[]{4, 1, 6, 2};
        int[] result = turner.back(input);
        int[] expect = new int[]{2, 6, 1, 4};
        assertThat(result, is(expect));
    }

    @Test
    public void whenTurnArrayWithOddNumberOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[]{4, 1, 6, 2, 5};
        int[] result = turner.back(input);
        int[] expect = new int[]{5, 2, 6, 1, 4};
        assertThat(result, is(expect));
    }
}
