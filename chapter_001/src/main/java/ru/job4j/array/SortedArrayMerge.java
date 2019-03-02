package ru.job4j.array;

public class SortedArrayMerge {

    public int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int posFirst = 0;
        int posSecond = 0;
        int index = 0;
        while (first.length > posFirst && second.length > posSecond) {
            result[index++] = first[posFirst] < second[posSecond] ? first[posFirst++] : second[posSecond++];
        }
        if (first.length > posFirst) {
            System.arraycopy(first, posFirst, result, index, first.length - posFirst);
        } else {
            System.arraycopy(second, posSecond, result, index, second.length - posSecond);
        }
        return result;
    }

}
