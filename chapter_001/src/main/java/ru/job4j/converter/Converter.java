package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {

    /**
     * Текущие курсы валют.
     */
    private final int eurRub = 70;
    private final int usdRub = 60;

    /**
     * Конвертирует рубли в евро.
     *
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / eurRub;
    }

    /**
     * Конвертирует евро в рубли.
     *
     * @param value евро.
     * @return Рубли.
     */
    public int euroToRuble(int value) {
        return value * eurRub;
    }

    /**
     * Конвертирует рубли в доллары.
     *
     * @param value рубли.
     * @return Доллары.
     */
    public int rubleToDollar(int value) {
        return value / usdRub;
    }

    /**
     * Конвертирует доллары в рубли.
     *
     * @param value доллары.
     * @return Рубли.
     */
    public int dollarToRuble(int value) {
        return value * usdRub;
    }
}

