package ru.job4j.calculator;

/**
 * Simple arithmetic calculator.
 *
 * @author Denis Abakumov
 */
public class Calculator {

    private double result;

    /**
     * Returns the result of last calculation.
     *
     * @return result.
     */
    public double getResult() {
        return result;
    }

    /**
     * Adds 2 numbers.
     *
     * @param first  first addend.
     * @param second second addend.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Subtracts one number from another.
     *
     * @param first  minuend.
     * @param second subtrahend.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Divides one number by another.
     *
     * @param first  dividend.
     * @param second divisor.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Multiplies 2 numbers.
     *
     * @param first  multiplicand.
     * @param second multiplier.
     */
    public void multiply(double first, double second) {
        this.result = first * second;
    }

}
