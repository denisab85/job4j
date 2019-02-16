package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Abakumov
 * @version $Id$
 */
public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSubtractThreeFromSevenThenFour() {
        Calculator calc = new Calculator();
        calc.subtract(7D, 3D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMultiplyFourByThreeThenTwelve() {
        Calculator calc = new Calculator();
        calc.multiply(4D, 3D);
        double result = calc.getResult();
        double expected = 12D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDivFifteenByThreeThenFive() {
        Calculator calc = new Calculator();
        calc.div(15D, 3D);
        double result = calc.getResult();
        double expected = 5D;
        assertThat(result, is(expected));
    }
}
