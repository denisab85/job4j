package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {

    /**
     * Текущие курсы валют.
     */
    private final int EUR_RUB = 70;
    private final int USD_RUB = 60;

    /**
     * Конвертирует рубли в евро.
     *
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / EUR_RUB;
    }

    /**
     * Конвертирует евро в рубли.
     *
     * @param value евро.
     * @return Рубли.
     */
    public int euroToRuble(int value) {
        return value * EUR_RUB;
    }

    /**
     * Конвертирует рубли в доллары.
     *
     * @param value рубли.
     * @return Доллары.
     */
    public int rubleToDollar(int value) {
        return value / USD_RUB;
    }

    /**
     * Конвертирует доллары в рубли.
     *
     * @param value доллары.
     * @return Рубли.
     */
    public int dollarToRuble(int value) {
        return value * USD_RUB;
    }
}

