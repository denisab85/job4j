package ru.job4j.calculator;

public class Calculator {

    private double result;

    public double getResult() {
        return result;
    }

    public void add(double first, double second) {
        this.result = first + second;
    }

    public void subtract(double first, double second) {
        this.result = first - second;
    }

    public void div(double first, double second) {
        this.result = first / second;
    }

    public void multiply(double first, double second) {
        this.result = first * second;
    }

}
