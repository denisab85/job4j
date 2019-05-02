package list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {

    /**
     * в метод приходит двумерный массив целых чисел,
     * необходимо пройтись по всем элементам массива и добавить их в List<Integer>.
     *
     * @param array двумерный массив целых чисел
     * @return
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int i : row) {
                list.add(i);
            }
        }
        return list;
    }
}