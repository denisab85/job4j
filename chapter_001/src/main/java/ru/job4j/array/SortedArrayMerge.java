package ru.job4j.array;

public class SortedArrayMerge {

    public int[] merge(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];

        int pos1 = 0;
        int pos2 = 0;
        int index = 0;
        while (array1.length > pos1 && array2.length > pos2) {
            result[index++] = array1[pos1] < array2[pos2] ? array1[pos1++] : array2[pos2++];
        }
        if (array1.length > pos1) {
            System.arraycopy(array1, pos1, result, index, array1.length - pos1);
        } else {
            System.arraycopy(array2, pos2, result, index, array2.length - pos2);
        }
        return result;
    }

}
