package list;

import java.util.LinkedList;
import java.util.List;

public class ConvertList2Array {

    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
        for (int row = 0; row < rows; row++) {
            for (int cell = 0; cell < cells; cell++) {
                int index = row * cells + cell;
                array[row][cell] = index < list.size() ? list.get(index) : 0;
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new LinkedList<>();
        for (int[] row : list) {
            for (int n : row) {
                result.add(n);
            }
        }
        return result;
    }
}
